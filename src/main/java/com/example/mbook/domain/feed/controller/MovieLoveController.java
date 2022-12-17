package com.example.mbook.domain.feed.controller;

import com.example.mbook.domain.feed.controller.response.BookLoveResponse;
import com.example.mbook.domain.feed.controller.response.MovieLoveResponse;
import com.example.mbook.domain.feed.service.MovieLoveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "movie_love", description = "영화 북마크 API 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieLoveController {
    private final MovieLoveService movieLoveService;

    @Operation(description = "북마크 누르기")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/like/{movieId}")
    public void wishPost(@PathVariable(name = "movieId") Long movieId) {
        movieLoveService.movieLike(movieId);
    }

    @Operation(description = "북마크 취소")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/like/cancel/{movieId}")
    public void wishCancel(@PathVariable(name = "movieId") Long movieId) {
        movieLoveService.movieLikeCancel(movieId);
    }

    @GetMapping("/like/list")
    public List<MovieLoveResponse> list(){
        return movieLoveService.movieLoveList();
    }
}
