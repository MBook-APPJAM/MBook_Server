package com.example.mbook.domain.book.service;

import com.example.mbook.domain.book.dto.BookList;
import com.example.mbook.domain.book.dto.BookRequest;
import com.example.mbook.domain.book.dto.BookResponse;

public interface BookService {
    void createBook(BookRequest request);

    BookResponse getBook(Long id);

    BookList bookCategoryList(String category);

    BookList bookTitleList(String title);
}
