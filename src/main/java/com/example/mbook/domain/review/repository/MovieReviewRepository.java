package com.example.mbook.domain.review.repository;

import com.example.mbook.domain.review.entity.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {
}
