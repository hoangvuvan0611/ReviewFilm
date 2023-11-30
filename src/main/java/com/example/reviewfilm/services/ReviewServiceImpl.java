package com.example.reviewfilm.services;

import com.example.reviewfilm.model.dtos.ReviewDTO;
import com.example.reviewfilm.model.entities.Movie;
import com.example.reviewfilm.model.entities.Review;
import com.example.reviewfilm.repositories.ReviewRepository;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final MongoTemplate mongoTemplate;

    public ReviewServiceImpl(ReviewRepository reviewRepository, MongoTemplate mongoTemplate) {
        this.reviewRepository = reviewRepository;
        this.mongoTemplate = mongoTemplate;
    }
    private ModelMapper modelMapper;

    @Override
    public Review createReview(String imdbId, String reviewBody) {
        Review review = reviewRepository.insert(Review.builder().body(reviewBody).build());
        review.setRvId(String.valueOf(review.getId().getTimestamp()));
        reviewRepository.save(review);
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }

    @Override
    public void deleteReview(String rvId, String imdbId) {
        Review review = singleReviewByRvId(rvId);
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().pull("reviewIds", review))
                .first();
        mongoTemplate.remove(review, "reviews");
    }

    @Override
    public Boolean checkExistReview(ObjectId id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.isPresent();
    }

    @Override
    public Review singleReviewByRvId(String rvId) {
        return reviewRepository.findReviewByRvId(rvId);
    }

    @Override
    public void updateReviewFavourite(String id) {
        Review review = singleReviewByRvId(id);
        review.setFavourite(review.getFavourite() + 1);
        reviewRepository.save(review);
    }
}
