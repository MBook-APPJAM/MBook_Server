package com.example.mbook.domain.chat.repository;

import com.example.mbook.domain.chat.entity.Chat;
import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<Chat, Long> {
}
