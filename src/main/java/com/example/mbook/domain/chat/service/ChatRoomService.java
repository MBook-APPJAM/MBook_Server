package com.example.mbook.domain.chat.service;

import com.example.mbook.domain.chat.controller.dto.ChatRoomDto;
import com.example.mbook.domain.chat.entity.ChatRoom;
import com.example.mbook.domain.chat.repository.ChatRepository;
import com.example.mbook.domain.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    private final ChatRepository chatRepository;
    private final ChatRoomRepository chatRoomRepository;

    @Transactional
    public ChatRoomDto createRoom(String roomName){
        ChatRoom chatRoom = new ChatRoom(roomName);
        chatRoomRepository.save(chatRoom);
        return ChatRoomDto.builder()
                .roomId(chatRoom.getId())
                .roomName(chatRoom.getRoomName())
                .build();
    }

    @Transactional
    public ChatRoomDto findRoom(Long roomId){
        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("not found room"));
        return ChatRoomDto.builder()
                .roomId(chatRoom.getId())
                .roomName(chatRoom.getRoomName())
                .build();
    }

    @Transactional
    public List<ChatRoomDto> findAllRoom(){
        List<ChatRoom> allRoom = (List<ChatRoom>) chatRoomRepository.findAll();
        return allRoom.stream().map(room -> new ChatRoomDto(
                room.getId(),
                room.getRoomName()
        )).collect(Collectors.toList());
    }
}
