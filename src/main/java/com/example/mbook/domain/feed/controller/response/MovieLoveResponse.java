package com.example.mbook.domain.feed.controller.response;

import com.example.mbook.domain.movie.entity.Movie;
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
public class MovieLoveResponse {
    private Long id;
    private User user;
    private Movie movie;
}
