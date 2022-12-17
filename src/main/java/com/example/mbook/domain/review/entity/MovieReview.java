package com.example.mbook.domain.review.entity;

import com.example.mbook.domain.movie.entity.Movie;
import com.example.mbook.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class MovieReview {
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
    private Movie movie;

    @Builder
    public MovieReview(String writer, String comments, Double grade, String imageUrl, User user, Movie movie){
        this.writer = writer;
        this.comments = comments;
        this.grade = grade;
        this.imageUrl =imageUrl;
        this.movie = movie;
        this.user = user;
    }

    public void setReview(String comments, Double grade){
        this.comments = comments;
        this.grade = grade;
    }
}
