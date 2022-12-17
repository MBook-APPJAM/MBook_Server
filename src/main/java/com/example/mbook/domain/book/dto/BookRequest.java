package com.example.mbook.domain.book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookRequest {
    private final String title;
    private final String content;
    private final String imageUrl;
    private final String localDate;
    private final String introduce;
    private final String category;
    private final String link;
}
