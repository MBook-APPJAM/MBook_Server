package com.example.mbook.domain.chat.controller.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatResponse {
    private Long roomId;
    private String sender;
    private String message;
}
