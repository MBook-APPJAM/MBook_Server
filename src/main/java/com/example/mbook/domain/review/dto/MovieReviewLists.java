package com.example.mbook.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MovieReviewLists {
    private final List<MovieReviewList> list;
}
