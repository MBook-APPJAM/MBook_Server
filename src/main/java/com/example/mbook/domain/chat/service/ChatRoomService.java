package com.example.mbook.domain.chat.service;

import com.example.mbook.domain.chat.repository.ChatRepository;
import com.example.mbook.domain.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    private final ChatRepository chatRepository;
    private final ChatRoomRepository chatRoomRepository;
}
