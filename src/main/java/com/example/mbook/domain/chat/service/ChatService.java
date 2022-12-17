package com.example.mbook.domain.chat.service;

import com.example.mbook.domain.chat.controller.payload.request.ChatRequest;
import com.example.mbook.domain.chat.entity.Chat;
import com.example.mbook.domain.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    @Transactional
    public void enter(ChatRequest request, SimpMessagingTemplate template){
        Chat chat = new Chat(request.getRoomId(), request.getSender() + "님이 참가하였습니다.", request.getSender());
        chatRepository.save(chat);
        template.convertAndSend("/topic/chat/room" + request.getRoomId(), chat);
    }

    @Transactional
    public void sendMessage(ChatRequest request, SimpMessagingTemplate template){
        Chat chat = new Chat(request.getRoomId(), request.getMessage(), request.getSender());
        chatRepository.save(chat);
        template.convertAndSend("/topic/chat/room" + request.getRoomId(), chat);
    }
}
