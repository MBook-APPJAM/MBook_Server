package com.example.mbook.domain.book.entity;

import com.example.mbook.domain.feed.entity.BookLove;
import com.example.mbook.domain.review.entity.BookReview;
import com.example.mbook.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String imageUrl;

    private String localDate;

    private String introduce;

    private String category;

    private Double average;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private List<BookLove> bookLoves;

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private List<BookReview> bookReviews;

    @Builder
    public Book(String title, String content, String imageUrl, String localDate, String introduce, User user, String category){
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.localDate = localDate;
        this.introduce = introduce;
        this.user = user;
        this.category = category;
    }

    public void setAverage(double average){
        this.average = average;
    }
}
