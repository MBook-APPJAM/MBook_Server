package com.example.mbook.domain.feed.repository;

import com.example.mbook.domain.feed.entity.MovieLove;
import com.example.mbook.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieLoveRepository extends JpaRepository<MovieLove, Long> {
    Optional<MovieLove> findMovieLoveByMovie(Movie movie);
}
