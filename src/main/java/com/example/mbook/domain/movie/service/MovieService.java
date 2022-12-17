package com.example.mbook.domain.movie.service;

import com.example.mbook.domain.book.dto.BookResponse;
import com.example.mbook.domain.movie.dto.MovieList;
import com.example.mbook.domain.movie.dto.MovieRequest;

public interface MovieService {
    void createMovie(MovieRequest request);

    BookResponse getMovie(Long id);

    MovieList movieCategoryList(String category);

    MovieList movieTitleList(String title);
}
