package com.example.mbook.domain.chat.controller.payload.request;

import lombok.Getter;

@Getter
public class ChatRoomRequest {
    private String roomName;
    private String tag;
    private String info;
    private String imageUrl;
}
