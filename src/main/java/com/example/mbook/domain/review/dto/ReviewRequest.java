package com.example.mbook.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewRequest {
    private String comments;

    private Double grade;

    private String imageUrl;
}
