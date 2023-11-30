package com.example.reviewfilm.services;

import com.example.reviewfilm.model.dtos.MovieDTO;
import com.example.reviewfilm.model.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {
    public List<Movie> allMovie();
    public Optional<Movie> singleMovieByImdbId(String imdbId);
}
