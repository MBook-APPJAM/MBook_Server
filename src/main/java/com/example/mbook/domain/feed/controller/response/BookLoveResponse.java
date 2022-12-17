package com.example.mbook.domain.feed.controller.response;

import com.example.mbook.domain.book.entity.Book;
import com.example.mbook.domain.feed.entity.BookLove;
import com.example.mbook.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookLoveResponse {
    private Long id;
    private User user;
    private Book book;
}
