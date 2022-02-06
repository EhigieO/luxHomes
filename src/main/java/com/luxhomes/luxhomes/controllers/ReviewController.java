package com.luxhomes.luxhomes.controllers;

import com.luxhomes.luxhomes.models.Review;
import com.luxhomes.luxhomes.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/lux/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }



    @PostMapping("/addReview")
    public String addReview(@RequestBody Review review){
        return reviewService.addReview(review);
    }
}
