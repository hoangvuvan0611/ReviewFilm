package com.example.reviewfilm.services;

import com.example.reviewfilm.model.entities.Review;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ReviewService {
    public Review createReview(String imdbId, String reviewBody);
    public void deleteReview(String rvId, String imdbId);
    public Boolean checkExistReview(ObjectId id);
    public Review singleReviewByRvId(String rvid);
    public void updateReviewFavourite(String id);
}
