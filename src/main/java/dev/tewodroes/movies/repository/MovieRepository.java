package dev.tewodroes.movies.repository;

import dev.tewodroes.movies.domain.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    public Optional<Movie> findMovieByImdbId(String imdbId);
}
