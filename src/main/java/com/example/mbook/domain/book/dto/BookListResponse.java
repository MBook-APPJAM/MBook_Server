package com.example.mbook.domain.book.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookListResponse {
    private final Long id;
    private final String title;
    private final String imageUrl;
    private final String category;
}
