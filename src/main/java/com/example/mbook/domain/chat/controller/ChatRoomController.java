package com.example.mbook.domain.chat.controller;

import com.example.mbook.domain.chat.controller.payload.request.ChatRoomRequest;
import com.example.mbook.domain.chat.controller.payload.response.ChatRoomResponse;
import com.example.mbook.domain.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @GetMapping("/chat/rooms")
    public List<ChatRoomResponse> getRoomList(){
        return chatRoomService.findAllRoom();
    }

    @GetMapping("/chat/room/{roomId}")
    public ChatRoomResponse getRoom(@PathVariable Long roomId){
        return chatRoomService.findRoom(roomId);
    }

    @PostMapping("/chat/room")
    public ChatRoomResponse createRoom(@RequestBody ChatRoomRequest request){
        return chatRoomService.createRoom(request.getRoomName());
    }

}
