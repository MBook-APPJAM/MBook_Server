package com.example.mbook.domain.movie.repository;

import com.example.mbook.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findById(Long id);

    @Query(value = "select m from Movie m where m.title LIKE %:title%")
    List<Movie> findAllMovieByTitleSearch(String title);

    @Query(value = "select m from Movie m where m.category LIKE %:category%")
    List<Movie> findAllByMovieByCategorySearch(String category);
}
