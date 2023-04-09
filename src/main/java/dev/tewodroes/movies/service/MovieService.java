package dev.tewodroes.movies.service;
import dev.tewodroes.movies.domain.Movie;
import dev.tewodroes.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(String imdbId){

        return movieRepository.findMovieByImdbId(imdbId).orElse(null);
    }


}
