package com.example.mbook.domain.review.service;

import com.example.mbook.domain.book.entity.Book;
import com.example.mbook.domain.book.facade.BookFacade;
import com.example.mbook.domain.review.dto.BookReviewList;
import com.example.mbook.domain.review.dto.BookReviewLists;
import com.example.mbook.domain.review.dto.ReviewRequest;
import com.example.mbook.domain.review.entity.BookReview;
import com.example.mbook.domain.review.repository.BookReviewRepository;
import com.example.mbook.domain.user.entity.User;
import com.example.mbook.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookReviewServiceImpl implements BookReviewService{
    private final BookReviewRepository bookReviewRepository;
    private final BookFacade bookFacade;
    private final UserFacade userFacade;

    @Override
    @Transactional
    public void createReview(ReviewRequest request, Long id){
        User user = userFacade.getCurrentUser();
        Book book = bookFacade.getBookById(id);

        bookReviewRepository.save(BookReview.builder()
                .writer(user.getNickName())
                .comments(request.getComments())
                .imageUrl(request.getImageUrl())
                .grade(request.getGrade())
                .user(user)
                .book(book).build());
    }

    @Override
    @Transactional
    public void delReview(Long id){
        BookReview book = bookReviewRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("review를 찾을수 없습니다."));
        userMath(book);
        bookReviewRepository.delete(book);

    }

    @Override
    @Transactional
    public void setReview(Long id, ReviewRequest request){
        BookReview book = bookReviewRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("review를 찾을수 없습니다."));
        userMath(book);
        book.setReview(request.getComments(), request.getGrade());
        bookReviewRepository.save(book);

    }

    @Override
    @Transactional(readOnly = true)
    public BookReviewLists myBookReview(){
        User user = userFacade.getCurrentUser();
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<BookReview> bookReviews = bookReviewRepository.findAll(sort);
        List<BookReviewList> bookReviewLists = new ArrayList<>();

        for (BookReview bookReview : bookReviews){
            if(bookReview.getUser().getEmail().equals(user.getEmail())){
                BookReviewList dto = BookReviewList.builder()
                        .title(bookReview.getBook().getTitle()).build();
                bookReviewLists.add(dto);
            }
        }
        return new BookReviewLists(bookReviewLists);
    }

    @Override
    @Transactional(readOnly = true)
    public BookReviewLists otherBookReview(Long id){
        User user = userFacade.getUserById(id);
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<BookReview> bookReviews = bookReviewRepository.findAll(sort);
        List<BookReviewList> bookReviewLists = new ArrayList<>();

        for (BookReview bookReview : bookReviews){
            if(bookReview.getUser().getEmail().equals(user.getEmail())) {
                BookReviewList dto = BookReviewList.builder()
                        .title(bookReview.getBook().getTitle()).build();
                bookReviewLists.add(dto);
            }
        }
        return new BookReviewLists(bookReviewLists);
    }

    @Override
    public BookReviewLists popularList() {
        List<BookReview> bookReviews = bookReviewRepository.findAll(Sort.by(Sort.Direction.DESC, "grade"));
        List<BookReviewList> bookReviewLists = new ArrayList<>();
        for(BookReview bookReview : bookReviews){
            BookReviewList dto = BookReviewList.builder()
                    .title(bookReview.getBook().getTitle()).build();
            bookReviewLists.add(dto);
        }
        return new BookReviewLists(bookReviewLists);
    }

    private void userMath(BookReview book) {
        User user = userFacade.getCurrentUser();
        if (book.getUser().getEmail().equals(user.getEmail())) {
        } else throw new IllegalStateException("작성한 댓글이 아닙니다.");
    }
}
