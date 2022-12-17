package com.example.mbook.domain.movie.controller;

import com.example.mbook.domain.movie.dto.MovieList;
import com.example.mbook.domain.movie.dto.MovieRequest;
import com.example.mbook.domain.movie.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Movie", description = "Movie 에 대한 API 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    @Operation(summary = "영화 생성")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createMovie(@RequestBody MovieRequest request){
        movieService.createMovie(request);
    }

    @Operation(summary = "영화 생성")
    @GetMapping("/detail/{movieId}")
    public void detailMovie(@PathVariable(name = "movieId")Long id){
        movieService.getMovie(id);
    }

    @Operation(summary = "영화 제목 검색")
    @GetMapping("/list/title")
    public MovieList titleMovieList(@RequestParam("value") String title){
        return movieService.movieTitleList(title);
    }

    @Operation(summary = "영화 카테고리 검색")
    @GetMapping("/list/category")
    public MovieList categoryMovieList(@RequestParam("value") String category){
        return movieService.movieCategoryList(category);
    }
}
