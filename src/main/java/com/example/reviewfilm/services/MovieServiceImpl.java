package com.example.reviewfilm.services;

import com.example.reviewfilm.model.entities.Movie;
import com.example.reviewfilm.repositories.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private ModelMapper modelMapper;
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> allMovie() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> singleMovieByImdbId(String imdbId) {
        return Optional.ofNullable(movieRepository.findMovieByImdbId(imdbId));
    }
}
