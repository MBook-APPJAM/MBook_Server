package com.example.mbook.domain.chat.service;

import com.example.mbook.domain.chat.controller.payload.response.ChatRoomResponse;
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
    public ChatRoomResponse createRoom(String roomName, String tag, String info, String imageUrl){
        ChatRoom chatRoom = new ChatRoom(roomName, tag, info, imageUrl);
        chatRoomRepository.save(chatRoom);
        return ChatRoomResponse.builder()
                .roomId(chatRoom.getId())
                .roomName(chatRoom.getRoomName())
                .tag(chatRoom.getTag())
                .info(chatRoom.getInfo())
                .imageUrl(chatRoom.getImageUrl())
                .build();
    }

    @Transactional
    public ChatRoomResponse findRoom(Long roomId){
        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("not found room"));
        return ChatRoomResponse.builder()
                .roomId(chatRoom.getId())
                .roomName(chatRoom.getRoomName())
                .tag(chatRoom.getTag())
                .info(chatRoom.getInfo())
                .imageUrl(chatRoom.getImageUrl())
                .build();
    }

    @Transactional
    public List<ChatRoomResponse> findAllRoom(){
        List<ChatRoom> allRoom = (List<ChatRoom>) chatRoomRepository.findAll();
        return allRoom.stream().map(room -> new ChatRoomResponse(
                room.getId(),
                room.getRoomName(),
                room.getTag(),
                room.getInfo(),
                room.getImageUrl()
        )).collect(Collectors.toList());
    }
}
