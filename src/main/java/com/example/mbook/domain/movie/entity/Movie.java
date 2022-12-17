package com.example.mbook.domain.movie.entity;

import com.example.mbook.domain.feed.entity.MovieLove;
import com.example.mbook.domain.review.entity.MovieReview;
import com.example.mbook.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String imageUrl;

    private String localDate;

    private String introduce;

    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE)
    private List<MovieLove> movieLoves;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE)
    private List<MovieReview> movieReviews;

    @Builder
    public Movie(String title, String content, String imageUrl, String localDate, String introduce, User user, String category){
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.localDate = localDate;
        this.introduce = introduce;
        this.user = user;
        this.category = category;
    }
}
