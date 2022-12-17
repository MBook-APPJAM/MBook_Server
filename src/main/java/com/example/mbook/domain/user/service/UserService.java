package com.example.mbook.domain.user.service;

import com.example.mbook.domain.user.dto.LoginRequest;
import com.example.mbook.domain.user.dto.EmailPasswordRequest;
import com.example.mbook.domain.user.dto.SignupRequest;
import com.example.mbook.domain.user.dto.UserResponse;
import com.example.mbook.global.mail.dto.MailRequest;

public interface UserService {
    // 회원 가입 POST, /user/signup
    void signup(SignupRequest request);

    void signupEmail(MailRequest mailDto) throws Exception;

    // 자체 로그인, POST , /user/login
    UserResponse login(LoginRequest request);

    void lostPassword(MailRequest mailDto) throws Exception;

    void setPasswordEmail(EmailPasswordRequest request);
}
