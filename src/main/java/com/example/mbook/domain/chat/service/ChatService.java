package com.example.mbook.domain.chat.service;

import com.example.mbook.domain.chat.repository.ChatRepository;
import com.example.mbook.domain.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatRoomRepository chatRoomRepository;
}
