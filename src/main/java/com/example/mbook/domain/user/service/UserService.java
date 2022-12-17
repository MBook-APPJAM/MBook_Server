package com.example.mbook.domain.user.service;

import com.example.mbook.domain.user.dto.LoginRequest;
import com.example.mbook.domain.user.dto.SignupRequest;
import com.example.mbook.domain.user.dto.UserResponse;

public interface UserService {
    // 회원 가입 POST, /user/signup
    void signup(SignupRequest request);

    // 자체 로그인, POST , /user/login
    UserResponse login(LoginRequest request);
}
