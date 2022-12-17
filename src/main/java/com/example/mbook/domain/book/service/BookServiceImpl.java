package com.example.mbook.domain.book.service;

import com.example.mbook.domain.book.dto.BookList;
import com.example.mbook.domain.book.dto.BookListResponse;
import com.example.mbook.domain.book.dto.BookRequest;
import com.example.mbook.domain.book.dto.BookResponse;
import com.example.mbook.domain.book.entity.Book;
import com.example.mbook.domain.book.facade.BookFacade;
import com.example.mbook.domain.book.repository.BookRepository;
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
public class BookServiceImpl implements BookService{
    private final UserFacade userFacade;
    private final BookFacade bookFacade;
    private final S3Facade s3Facade;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public void createBook(BookRequest request){
        User user = userFacade.getCurrentUser();
        bookRepository.save(Book.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .imageUrl(request.getImageUrl())
                .localDate(request.getLocalDate())
                .introduce(request.getIntroduce())
                .category(request.getCategory())
                .user(user)
                .link(request.getLink()).build());
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse getBook(Long id){
        Book book = bookFacade.getBookById(id);
        return BookResponse.builder()
                .title(book.getTitle())
                .content(book.getContent())
                .id(book.getId())
                .imageUrl(book.getImageUrl())
                .localDate(book.getLocalDate())
                .introduce(book.getIntroduce())
                .link(book.getLink()).build();
    }

    @Transactional(readOnly = true)
    @Override
    public BookList bookCategoryList(String category) {
        List<Book> books = bookFacade.getAllBookByCategorySearch(category);
        List<BookListResponse> bookLists = new ArrayList<>();

        for (Book book : books) {
                BookListResponse dto = BookListResponse.builder()
                        .id(book.getId())
                        .title(book.getTitle())
                        .category(book.getCategory())
                        .imageUrl(s3Facade.getUrl(book.getImageUrl()))
                        .build();
                bookLists.add(dto);
        }
        return new BookList(bookLists);
    }

    @Transactional(readOnly = true)
    @Override
    public BookList bookTitleList(String title) {
        List<Book> books = bookFacade.getAllBookByTitleSearch(title);
        List<BookListResponse> bookLists = new ArrayList<>();

        for (Book book : books) {
            BookListResponse dto = BookListResponse.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .category(book.getCategory())
                    .imageUrl(s3Facade.getUrl(book.getImageUrl()))
                    .build();
            bookLists.add(dto);
        }
        return new BookList(bookLists);
    }

}
