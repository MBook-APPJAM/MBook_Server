package com.example.mbook.domain.chat.controller.dto;

import com.example.mbook.domain.chat.entity.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatDto {
    private Long roomId;
    private MessageType type;
    private String sender;
    private String message;
}
