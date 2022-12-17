package com.example.mbook.domain.feed.service;


import com.example.mbook.domain.feed.controller.response.MovieLoveResponse;

import java.util.List;

public interface MovieLoveService {
    void movieLike(Long movieId);

    void movieLikeCancel(Long movieId);

    List<MovieLoveResponse> movieLoveList();
}
