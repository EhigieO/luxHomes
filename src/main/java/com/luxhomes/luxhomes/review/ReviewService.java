package com.luxhomes.luxhomes.review;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public String addReview(Review review){
        reviewRepository.save(review);
        return "review saved";
    }

    public Review findReviewById(Long reviewId){
        Optional<Review> review = reviewRepository.findById(reviewId);
        return review.orElse(null);
    }

    public String deleteReview(Long reviewId){
        reviewRepository.deleteById(reviewId);
        return "review deleted";
    }

    public String deleteReview(Review review){
        reviewRepository.delete(review);
        return "review deleted";
    }

}
