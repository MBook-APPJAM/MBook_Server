package com.example.mbook.domain.chat.controller.payload.request;

import lombok.Getter;

@Getter
public class ChatRequest {
    private Long roomId;
    private String sender;
    private String message;
}
