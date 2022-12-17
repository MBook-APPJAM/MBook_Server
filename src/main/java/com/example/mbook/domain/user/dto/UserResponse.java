package com.example.mbook.domain.user.dto;

import com.example.mbook.domain.user.entity.Role;
import com.example.mbook.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
    private final String email;
    private final String nickName;
    private final Role role;

    public static UserResponse of(User user){
        return UserResponse.builder()
                .nickName(user.getNickName())
                .email(user.getEmail())
                .role(user.getRole()).build();
    }
}
