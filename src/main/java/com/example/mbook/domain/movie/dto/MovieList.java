package com.example.mbook.domain.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MovieList {
    private final List<MovieListResponse> list;
}
