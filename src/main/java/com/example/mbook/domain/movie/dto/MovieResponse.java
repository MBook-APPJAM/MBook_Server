package com.example.mbook.domain.movie.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieResponse {
    private final String title;
    private final String content;
    private final Long id;
    private final String imageUrl;
    private final String localDate;
    private final String introduce;
    private final Double grade;
    private final String category;
}
