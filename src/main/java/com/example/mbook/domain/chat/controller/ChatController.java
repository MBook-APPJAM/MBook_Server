package com.example.mbook.domain.chat.controller;

import com.example.mbook.domain.chat.controller.payload.request.ChatRequest;
import com.example.mbook.domain.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    private final SimpMessagingTemplate template;

    @MessageMapping(value = "/chat/enter")
    public void enter(ChatRequest request){
        chatService.enter(request, template);
    }

    @MessageMapping(value = "/chat/message")
    public void sendMessage(ChatRequest request){
        chatService.sendMessage(request, template);
    }
}
