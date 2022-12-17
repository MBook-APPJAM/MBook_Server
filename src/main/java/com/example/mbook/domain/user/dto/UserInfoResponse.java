package com.example.mbook.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResponse {
    private final Long userId;
    private final String nickName;
    private final String imgUrl;
}
