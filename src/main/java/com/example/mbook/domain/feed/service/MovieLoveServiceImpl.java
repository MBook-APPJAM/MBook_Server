package com.example.mbook.domain.feed.service;

import com.example.mbook.domain.feed.controller.response.BookLoveResponse;
import com.example.mbook.domain.feed.controller.response.MovieLoveResponse;
import com.example.mbook.domain.feed.entity.MovieLove;
import com.example.mbook.domain.feed.repository.MovieLoveRepository;
import com.example.mbook.domain.movie.entity.Movie;
import com.example.mbook.domain.movie.facade.MovieFacade;
import com.example.mbook.domain.user.entity.User;
import com.example.mbook.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieLoveServiceImpl implements MovieLoveService{
    private final UserFacade userFacade;
    private final MovieFacade movieFacade;
    private final MovieLoveRepository movieLoveRepository;

    @Override
    @Transactional
    public void movieLike(Long movieId){
        User user = userFacade.getCurrentUser();
        Movie movie = movieFacade.getMovieById(movieId);

        MovieLove movieLove = MovieLove.builder()
                .user(user)
                .movie(movie).build();

        movieLoveRepository.save(movieLove);
    }

    @Override
    @Transactional
    public void movieLikeCancel(Long movieId){
        User user = userFacade.getCurrentUser();
        Movie movie = movieFacade.getMovieById(movieId);
        List<MovieLove> like = movie.getMovieLoves();

        for(MovieLove m : like){
            if(m.getUser().equals(user)){

                movieLoveRepository.delete(m);
            }
        }
    }

    @Override
    public List<MovieLoveResponse> movieLoveList() {
        User user = userFacade.getCurrentUser();
        List<MovieLove> movieLoves = movieLoveRepository.findByUser(user);
        return movieLoves.stream().map(movie -> new MovieLoveResponse(
                movie.getId(),
                movie.getUser(),
                movie.getMovie()
        )).collect(Collectors.toList());
    }

}
