package com.example.mbook.domain.feed.service;


import com.example.mbook.domain.feed.controller.response.BookLoveResponse;

import java.util.List;

public interface BookLoveService {
    void bookLike(Long bookId);

    void bookLikeCancel(Long bookId);

    List<BookLoveResponse> bookLoveList();
}
