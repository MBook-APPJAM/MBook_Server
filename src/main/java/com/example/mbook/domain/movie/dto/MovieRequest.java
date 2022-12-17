package com.example.mbook.domain.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MovieRequest {
    private final String title;
    private final String content;
    private final String imageUrl;
    private final String localDate;
    private final String introduce;
    private final String category;
}
