package com.example.mbook.domain.feed.repository;

import com.example.mbook.domain.book.entity.Book;
import com.example.mbook.domain.feed.entity.BookLove;
import com.example.mbook.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookLoveRepository extends JpaRepository<BookLove, Long> {
    Optional<BookLove> findBookLoveByBook(Book book);
    List<BookLove> findByUser(User user);
}
