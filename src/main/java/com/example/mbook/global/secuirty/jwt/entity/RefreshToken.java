package com.example.mbook.global.secuirty.jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@Getter
@AllArgsConstructor
@Builder
public class RefreshToken {

    @Id
    private String email;

    private String rtk;

    private Long rtkTime;
}
