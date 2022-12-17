package com.example.mbook.domain.book.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookResponse {
    private final String title;
    private final String content;
    private final Long id;
    private final String imageUrl;
    private final String localDate;
    private final String introduce;
    private final String category;
    private final String link;
}
