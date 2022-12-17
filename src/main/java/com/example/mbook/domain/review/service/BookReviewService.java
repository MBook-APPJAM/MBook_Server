package com.example.mbook.domain.review.service;


import com.example.mbook.domain.review.dto.BookReviewLists;
import com.example.mbook.domain.review.dto.ReviewRequest;

public interface BookReviewService {
    void createReview(ReviewRequest request, Long id);

    void delReview(Long id);

    void setReview(Long id, ReviewRequest request);

    BookReviewLists myBookReview();

    BookReviewLists otherBookReview(Long id);

    BookReviewLists popularList();
}
