package com.example.mbook.domain.book.repository;

import com.example.mbook.domain.book.entity.Book;
import com.example.mbook.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findById(Long id);

    @Query(value = "select b from Book b where b.title LIKE %:title%")
    List<Book> findAllBookByTitleSearch(String title);

    @Query(value = "select b from Book b where b.category LIKE %:category%")
    List<Book> findAllByBookByCategorySearch(String category);
}
