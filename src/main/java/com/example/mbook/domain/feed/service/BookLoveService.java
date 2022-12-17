package com.example.mbook.domain.feed.service;


public interface BookLoveService {
    void bookLike(Long bookId);

    void bookLikeCancel(Long bookId);
}
