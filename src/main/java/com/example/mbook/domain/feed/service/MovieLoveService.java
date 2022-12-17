package com.example.mbook.domain.feed.service;


public interface MovieLoveService {
    void movieLike(Long movieId);

    void movieLikeCancel(Long movieId);
}
