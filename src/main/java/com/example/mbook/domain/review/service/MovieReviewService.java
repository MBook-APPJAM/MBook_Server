package com.example.mbook.domain.review.service;

import com.example.mbook.domain.review.dto.MovieReviewLists;
import com.example.mbook.domain.review.dto.ReviewRequest;

public interface MovieReviewService {
    void createReview(ReviewRequest request, Long id);

    void delMovieReview(Long id);

    void setReview(Long id, ReviewRequest request);

    MovieReviewLists myMovieReview();

    MovieReviewLists otherMovieReview(Long id);
}
