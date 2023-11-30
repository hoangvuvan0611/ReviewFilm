package com.example.reviewfilm.controllers;

import com.example.reviewfilm.model.entities.Movie;
import com.example.reviewfilm.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movie")
public class MoviesController {

    private final MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> allmovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovie(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> singleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByImdbId(imdbId), HttpStatus.OK);
    }
}

