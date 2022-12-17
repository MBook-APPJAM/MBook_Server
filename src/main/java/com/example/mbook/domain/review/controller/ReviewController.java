package com.example.mbook.domain.review.controller;

import com.example.mbook.domain.book.service.BookService;
import com.example.mbook.domain.movie.service.MovieService;
import com.example.mbook.domain.review.dto.BookReviewLists;
import com.example.mbook.domain.review.dto.MovieReviewList;
import com.example.mbook.domain.review.dto.MovieReviewLists;
import com.example.mbook.domain.review.dto.ReviewRequest;
import com.example.mbook.domain.review.service.BookReviewService;
import com.example.mbook.domain.review.service.MovieReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Review", description = "Review 에 대한 API 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final MovieReviewService movieService;
    private final BookReviewService bookService;

    @Operation(summary = "영화 리뷰 작성")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/movie/{movieId}")
    public void createMovie(@RequestBody ReviewRequest request, @PathVariable(name = "movieId")Long id) {
        movieService.createReview(request, id);
    }

    @Operation(summary = "책 리뷰 작성")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/book/{bookId}")
    public void createBook(@RequestBody ReviewRequest request, @PathVariable(name = "bookId")Long id) {
        bookService.createReview(request, id);
    }

    @Operation(summary = "영화 리뷰 수정")
    @PatchMapping("/movie/{movieId}")
    public void setMovie(@RequestBody ReviewRequest request, @PathVariable(name = "movieId")Long id) {
        movieService.setReview(id,request);
    }

    @Operation(summary = "책 리뷰 수정")
    @PatchMapping("/book/{bookId}")
    public void setBook(@RequestBody ReviewRequest request, @PathVariable(name = "bookId")Long id) {
        bookService.setReview(id,request);
    }

    @Operation(summary = "영화 리뷰 삭제")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/movie/{movieId}")
    public void setMovie(@PathVariable(name = "movieId")Long id) {
        movieService.delMovieReview(id);
    }

    @Operation(summary = "책 리뷰 삭제")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/book/{bookId}")
    public void setBook(@PathVariable(name = "bookId")Long id) {
        bookService.delReview(id);
    }

    @Operation(summary = "나의 영화 리뷰 보기")
    @DeleteMapping("/movie/my")
    public MovieReviewLists myMovie() {
        return movieService.myMovieReview();
    }

    @Operation(summary = "나의 책 리뷰 보기")
    @DeleteMapping("/book/my")
    public BookReviewLists myBook() {
        return bookService.myBookReview();
    }

    @Operation(summary = "다른사람 영화 리뷰 보기")
    @DeleteMapping("/{userId}")
    public MovieReviewLists otherMovie(@PathVariable(name = "userId")Long id) {
        return movieService.otherMovieReview(id);
    }

    @Operation(summary = "다른사람 책 리뷰 보기")
    @DeleteMapping("/{userId}")
    public BookReviewLists otherBook(@PathVariable(name = "userId")Long id) {
        return bookService.otherBookReview(id);
    }


}
