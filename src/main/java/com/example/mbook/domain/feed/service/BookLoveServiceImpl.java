package com.example.mbook.domain.feed.service;

import com.example.mbook.domain.book.entity.Book;
import com.example.mbook.domain.book.facade.BookFacade;
import com.example.mbook.domain.feed.entity.BookLove;
import com.example.mbook.domain.feed.repository.BookLoveRepository;
import com.example.mbook.domain.user.entity.User;
import com.example.mbook.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLoveServiceImpl implements BookLoveService {
    private final UserFacade userFacade;
    private final BookFacade bookFacade;
    private final BookLoveRepository bookLoveRepository;

    @Override
    @Transactional
    public void bookLike(Long bookId) {
        User user = userFacade.getCurrentUser();
        Book book = bookFacade.getBookById(bookId);

        BookLove bookLove = BookLove.builder()
                .user(user)
                .book(book).build();

        bookLoveRepository.save(bookLove);
    }

    @Override
    @Transactional
    public void bookLikeCancel(Long bookId) {
        User user = userFacade.getCurrentUser();
        Book book = bookFacade.getBookById(bookId);
        List<BookLove> like = book.getBookLoves();

        for (BookLove b : like) {
            if (b.getUser().equals(user)) {

                bookLoveRepository.delete(b);
            }
        }
    }
}
