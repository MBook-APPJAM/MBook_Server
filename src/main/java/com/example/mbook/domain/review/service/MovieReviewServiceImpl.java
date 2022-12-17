package com.example.mbook.domain.review.service;

import com.example.mbook.domain.book.entity.Book;
import com.example.mbook.domain.movie.entity.Movie;
import com.example.mbook.domain.movie.facade.MovieFacade;
import com.example.mbook.domain.review.dto.*;
import com.example.mbook.domain.review.entity.BookReview;
import com.example.mbook.domain.review.entity.MovieReview;
import com.example.mbook.domain.review.repository.MovieReviewRepository;
import com.example.mbook.domain.user.entity.User;
import com.example.mbook.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieReviewServiceImpl implements MovieReviewService{
    private final UserFacade userFacade;
    private final MovieReviewRepository movieReviewRepository;
    private final MovieFacade movieFacade;


    @Override
    @Transactional
    public void createReview(ReviewRequest request, Long id){
        User user = userFacade.getCurrentUser();
        Movie movie = movieFacade.getMovieById(id);

        movieReviewRepository.save(MovieReview.builder()
                .writer(user.getNickName())
                .comments(request.getComments())
                .imageUrl(request.getImageUrl())
                .grade(request.getGrade())
                .user(user)
                .movie(movie).build());
    }

    @Override
    @Transactional
    public void delMovieReview(Long id){
        MovieReview movieReview = movieReviewRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("review를 찾을수 없습니다."));
        userMath(movieReview);
        movieReviewRepository.delete(movieReview);

    }

    @Override
    @Transactional
    public void setReview(Long id, ReviewRequest request){
        MovieReview movieReview = movieReviewRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("review를 찾을수 없습니다."));
        userMath(movieReview);
        movieReview.setReview(request.getComments(), request.getGrade());
        movieReviewRepository.save(movieReview);

    }

    @Override
    @Transactional(readOnly = true)
    public MovieReviewLists myMovieReview(){
        User user = userFacade.getCurrentUser();
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<MovieReview> movieReviews = movieReviewRepository.findAll(sort);
        List<MovieReviewList> movieReviewLists = new ArrayList<>();

        for (MovieReview movieReview : movieReviews){
            if(movieReview.getUser().getEmail().equals(user.getEmail())){
                MovieReviewList dto = MovieReviewList.builder()
                        .title(movieReview.getMovie().getTitle()).build();
                movieReviewLists.add(dto);
            }
        }
        return new MovieReviewLists(movieReviewLists);
    }

    @Override
    @Transactional(readOnly = true)
    public MovieReviewLists otherMovieReview(Long id){
        User user = userFacade.getUserById(id);
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<MovieReview> movieReviews = movieReviewRepository.findAll(sort);
        List<MovieReviewList> movieReviewLists = new ArrayList<>();

        for (MovieReview movieReview : movieReviews){
            if(movieReview.getUser().getEmail().equals(user.getEmail())) {
                MovieReviewList dto = MovieReviewList.builder()
                        .title(movieReview.getMovie().getTitle()).build();
                movieReviewLists.add(dto);
            }
        }
        return new MovieReviewLists(movieReviewLists);
    }

    private void userMath(MovieReview movie) {
        User user = userFacade.getCurrentUser();
        if (movie.getUser().getEmail().equals(user.getEmail())) {
        } else throw new IllegalStateException("작성한 댓글이 아닙니다.");
    }
}
