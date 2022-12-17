package com.example.mbook.domain.book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BookList {
    private final List<BookListResponse> list;
}
