package com.example.mbook.domain.user.controller;

import com.example.mbook.domain.user.dto.LoginRequest;
import com.example.mbook.domain.user.dto.EmailPasswordRequest;
import com.example.mbook.domain.user.dto.SignupRequest;
import com.example.mbook.domain.user.dto.UserResponse;
import com.example.mbook.domain.user.service.UserService;
import com.example.mbook.global.mail.dto.MailRequest;
import com.example.mbook.global.secuirty.auth.AuthDetails;
import com.example.mbook.global.secuirty.jwt.JwtProvider;
import com.example.mbook.global.secuirty.jwt.dto.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "user", description = "유저에 대한 API 입니다.")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final JwtProvider jwtProvider;
    private final UserService userService;

    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@Valid @RequestBody SignupRequest request){ userService.signup(request);}

    @Operation(summary = "로그인")
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse login(@RequestBody LoginRequest request){
        UserResponse userResponse = userService.login(request);
        return jwtProvider.createTokenByLogin(userResponse);
    }

    @Operation(summary = "토큰 재발급")
    @PostMapping("/reissue")
    public TokenResponse reissue(
            @AuthenticationPrincipal AuthDetails authDetails){
        UserResponse userResponse = UserResponse.of(authDetails.getUser());
        return jwtProvider.reissueAtk(userResponse);
    }

    @Operation(summary = "회원가입 이메일 인증")
    @PostMapping("/email")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signupEmail(@RequestBody MailRequest request) throws Exception {
        userService.signupEmail(request);
    }

    @Operation(summary = "비밀번호 찾기-이메일 입력")
    @PostMapping("/lost/password")
    public void mail(@Valid @RequestBody MailRequest dto)throws Exception{
        userService.lostPassword(dto);
    }

    @Operation(summary = "이메일-비밀번호 찾기")
    @PatchMapping("/lost/password")
    public void setEmailPassword(@Valid @RequestBody EmailPasswordRequest request){
        userService.setPasswordEmail(request);
    }

}
