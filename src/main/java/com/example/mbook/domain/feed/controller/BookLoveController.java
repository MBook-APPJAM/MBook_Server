package com.example.mbook.domain.feed.controller;

import com.example.mbook.domain.feed.service.BookLoveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "book_love", description = "책 북마크 API 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookLoveController {
    private final BookLoveService bookLoveService;

    @Operation(description = "북마크 누르기")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/like/{bookId}")
    public void wishPost(@PathVariable(name = "bookId") Long bookId) {
        bookLoveService.bookLike(bookId);
    }

    @Operation(description = "북마크 취소")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/like/cancel/{bookId}")
    public void wishCancel(@PathVariable(name = "bookId") Long bookId) {
        bookLoveService.bookLikeCancel(bookId);
    }

}
