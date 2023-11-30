package com.example.reviewfilm.controllers;

import com.example.reviewfilm.model.entities.Review;
import com.example.reviewfilm.requests.DeleteReviewRequest;
import com.example.reviewfilm.services.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/favourite")
    public void updateReviewFavourite(@RequestBody DeleteReviewRequest deleteReviewRequest){
        reviewService.updateReviewFavourite(deleteReviewRequest.getRvId());
    }

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<>(reviewService.createReview(payload.get("imdbId"), payload.get("reviewBody")), HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public ResponseEntity deleteReview(@RequestBody DeleteReviewRequest deleteReviewRequest){
        reviewService.deleteReview(deleteReviewRequest.getRvId(), deleteReviewRequest.getImdbId());
        return ResponseEntity.ok().build();
    }
}
