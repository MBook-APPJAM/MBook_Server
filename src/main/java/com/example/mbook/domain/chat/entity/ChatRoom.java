package com.example.mbook.domain.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.web.socket.WebSocketSession;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@RedisHash
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomName;

    Set<WebSocketSession> sessions = new HashSet<>();

    public ChatRoom(String roomName){
        this.roomName = roomName;
    }
}
