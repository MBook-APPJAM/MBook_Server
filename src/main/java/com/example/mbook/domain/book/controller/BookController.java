package com.example.mbook.domain.book.controller;

import com.example.mbook.domain.book.dto.BookList;
import com.example.mbook.domain.book.dto.BookRequest;
import com.example.mbook.domain.book.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Operation(summary = "책 생성")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createBook(@RequestBody BookRequest request) {
        bookService.createBook(request);
    }

    @Operation(summary = "책 생성")
    @GetMapping("/detail/{bookId}")
    public void detailBook(@PathVariable(name = "bookId") Long id) {
        bookService.getBook(id);
    }

    @Operation(summary = "책 제목 검색")
    @GetMapping("/list/title")
    public BookList titleBookList(@RequestParam("value") String title) {
        return bookService.bookTitleList(title);
    }

    @Operation(summary = "책 카테고리 검색")
    @GetMapping("/list/category")
    public BookList categoryBookList(@RequestParam("value") String category) {
        return bookService.bookCategoryList(category);
    }
}
