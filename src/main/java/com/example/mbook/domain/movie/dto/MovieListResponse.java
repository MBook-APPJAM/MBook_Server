package com.example.mbook.domain.movie.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieListResponse {
    private final Long id;
    private final String title;
    private final String imageUrl;
    private final String category;
}
