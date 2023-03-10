package com.example.mbook.domain.user.facade;

import com.example.mbook.domain.user.entity.User;
import com.example.mbook.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(accountId);
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

    }

    public User getUserByNickName(String nickName) {
        return userRepository.findUserByNickName(nickName)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("이메일을 찾을 수 없습니다."));
    }
}
