package com.example.mbook.domain.user.service;

import com.example.mbook.domain.user.dto.*;
import com.example.mbook.global.mail.dto.MailRequest;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    // 회원 가입 POST, /user/signup
    void signup(SignupRequest request);

    void signupEmail(MailRequest mailDto) throws Exception;

    // 자체 로그인, POST , /user/login
    UserResponse login(LoginRequest request);

    void lostPassword(MailRequest mailDto) throws Exception;

    void setPasswordEmail(EmailPasswordRequest request);

    void setPasswords(PasswordRequest request);

    void setUser(UserRequest request);

    void leaveUser();

    UserInfoResponse getUser();

    UserInfoResponse getOtherUser(Long id);
}
