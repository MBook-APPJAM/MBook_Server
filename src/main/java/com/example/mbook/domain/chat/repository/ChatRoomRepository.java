package com.example.mbook.domain.chat.repository;

import com.example.mbook.domain.chat.entity.ChatRoom;
import org.springframework.data.repository.CrudRepository;

public interface ChatRoomRepository extends CrudRepository<ChatRoom, Long> {
}
