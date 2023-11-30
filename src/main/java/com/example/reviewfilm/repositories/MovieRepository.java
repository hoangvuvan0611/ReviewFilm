package com.example.reviewfilm.repositories;

import com.example.reviewfilm.model.entities.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    public Movie findMovieByImdbId(String imdbId);
}
