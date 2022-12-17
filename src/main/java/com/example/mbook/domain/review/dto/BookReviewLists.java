package com.example.mbook.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BookReviewLists {
    private List<BookReviewList> list;
}
