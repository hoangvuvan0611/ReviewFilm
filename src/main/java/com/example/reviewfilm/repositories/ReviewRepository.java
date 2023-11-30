package com.example.reviewfilm.repositories;

import com.example.reviewfilm.model.entities.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
    public Review findReviewByRvId(String id);

    @DeleteQuery()
    public void deleteReviewByRvId(String id);
}
