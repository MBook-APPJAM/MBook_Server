package com.example.mbook.domain.user.service;

import com.example.mbook.domain.user.dto.LoginRequest;
import com.example.mbook.domain.user.dto.SignupRequest;
import com.example.mbook.domain.user.dto.UserResponse;
import com.example.mbook.domain.user.entity.User;
import com.example.mbook.domain.user.facade.UserFacade;
import com.example.mbook.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserFacade userFacade;
    private final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;

    @Override
    public void signup(SignupRequest request) {
        boolean exists = userRepository.existsByEmail(request.getEmail());
        boolean exists2 = userRepository.existsByNickName(request.getNickName());
        if (exists) throw new IllegalStateException("이미 가입하신 이메일 입니다.");
        if (exists2) throw new IllegalStateException("이미 있는 닉네임 입니다.");

        User user = User.builder()
                .nickName(request.getNickName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())).build();

        userRepository.save(user);
    }

    @Transactional
    @Override
    public UserResponse login(LoginRequest request) {

        User user = userFacade.getUserByAccountId(request.getEmail());

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalStateException("비밀번호가 맞지 않습니다.");
        }

        return UserResponse.of(user);
    }
}
