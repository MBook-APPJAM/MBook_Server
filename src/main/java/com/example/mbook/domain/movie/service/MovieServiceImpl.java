package com.example.mbook.domain.movie.service;

import com.example.mbook.domain.book.dto.BookResponse;
import com.example.mbook.domain.movie.dto.MovieList;
import com.example.mbook.domain.movie.dto.MovieListResponse;
import com.example.mbook.domain.movie.dto.MovieRequest;
import com.example.mbook.domain.movie.entity.Movie;
import com.example.mbook.domain.movie.facade.MovieFacade;
import com.example.mbook.domain.movie.repository.MovieRepository;
import com.example.mbook.domain.user.entity.User;
import com.example.mbook.domain.user.facade.UserFacade;
import com.example.mbook.global.s3.facade.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieFacade movieFacade;
    private final UserFacade userFacade;
    private final S3Facade s3Facade;

    @Override
    @Transactional
    public void createMovie(MovieRequest request) {
        User user = userFacade.getCurrentUser();
        movieRepository.save(Movie.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .imageUrl(request.getImageUrl())
                .localDate(request.getLocalDate())
                .introduce(request.getIntroduce())
                .user(user)
                .link(request.getLink()).build());
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse getMovie(Long id) {
        Movie movie = movieFacade.getMovieById(id);
        return BookResponse.builder()
                .title(movie.getTitle())
                .content(movie.getContent())
                .id(movie.getId())
                .imageUrl(movie.getImageUrl())
                .localDate(movie.getLocalDate())
                .introduce(movie.getIntroduce())
                .link(movie.getLink()).build();
    }

    @Transactional(readOnly = true)
    @Override
    public MovieList movieCategoryList(String category) {
        List<Movie> movies = movieFacade.getAllMovieByCategorySearch(category);
        List<MovieListResponse> movieLists = new ArrayList<>();

        for (Movie movie : movies) {
            MovieListResponse dto = MovieListResponse.builder()
                    .id(movie.getId())
                    .title(movie.getTitle())
                    .category(movie.getCategory())
                    .imageUrl(s3Facade.getUrl(movie.getImageUrl()))
                    .build();
            movieLists.add(dto);
        }
        return new MovieList(movieLists);
    }

    @Transactional(readOnly = true)
    @Override
    public MovieList movieTitleList(String title) {
        List<Movie> movies = movieFacade.getAllMovieByTitleSearch(title);
        List<MovieListResponse> movieLists = new ArrayList<>();

        for (Movie movie : movies) {
            MovieListResponse dto = MovieListResponse.builder()
                    .id(movie.getId())
                    .title(movie.getTitle())
                    .category(movie.getCategory())
                    .imageUrl(s3Facade.getUrl(movie.getImageUrl()))
                    .build();
            movieLists.add(dto);
        }
        return new MovieList(movieLists);
    }

}
