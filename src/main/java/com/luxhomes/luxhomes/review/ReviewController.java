package com.luxhomes.luxhomes.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/lux-homes/review")
public class ReviewController {


    private ReviewService reviewService;

    @PostMapping("/addReview")
    public String addReview(@RequestBody Review review){
        return reviewService.addReview(review);
    }
}
