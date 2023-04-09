package dev.tewodroes.movies.controller;

import dev.tewodroes.movies.domain.Movie;
import dev.tewodroes.movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<?> getMovieByImdbId(@PathVariable String imdbId){
        if(movieService.getMovieById(imdbId)==null){
            return new ResponseEntity<String>("Movie with imdb-id "+imdbId+" is not found.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Movie>(movieService.getMovieById(imdbId), HttpStatus.OK);
    }

}
