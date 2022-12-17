package com.example.mbook.domain.movie.facade;

import com.example.mbook.domain.book.entity.Book;
import com.example.mbook.domain.movie.entity.Movie;
import com.example.mbook.domain.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieFacade {
    private final MovieRepository movieRepository;

    public Movie getMovieById(Long id){
        return movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("영화를 찾을 수 없습니다."));
    }

    public List<Movie> getMovieAllById(Sort sort){
        return movieRepository.findAll(sort);
    }

    public List<Movie> getAllMovieByTitleSearch(String title){return movieRepository.findAllMovieByTitleSearch(title);}

    public List<Movie> getAllMovieByCategorySearch(String category){return movieRepository.findAllByMovieByCategorySearch(category);}

}

