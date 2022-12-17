package com.example.mbook.domain.review.entity;

import com.example.mbook.domain.book.entity.Book;
import com.example.mbook.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;

    private String comments;

    private Double grade;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Builder
    public BookReview(String writer, String comments, Double grade, String imageUrl, User user, Book book){
        this.writer = writer;
        this.comments = comments;
        this.grade = grade;
        this.imageUrl =imageUrl;
        this.book = book;
        this.user = user;
    }

    public void setReview(String comments, Double grade){
        this.comments = comments;
        this.grade = grade;
    }
}
