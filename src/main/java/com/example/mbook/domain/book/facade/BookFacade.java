package com.example.mbook.domain.book.facade;

import com.example.mbook.domain.book.entity.Book;
import com.example.mbook.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookFacade {
    private final BookRepository bookRepository;

    public Book getBookById(Long id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("책을 찾을 수 없습니다."));
    }

    public List<Book> getBoardAllById(Sort sort){
        return bookRepository.findAll(sort);
    }

    public List<Book> getAllBookByTitleSearch(String title){return bookRepository.findAllBookByTitleSearch(title);}

    public List<Book> getAllBookByCategorySearch(String category){return bookRepository.findAllByBookByCategorySearch(category);}
}
