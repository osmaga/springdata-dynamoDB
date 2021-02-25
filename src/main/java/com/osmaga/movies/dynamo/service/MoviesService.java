package com.osmaga.movies.dynamo.service;

import com.osmaga.movies.dynamo.entity.Movie;
import com.osmaga.movies.dynamo.persistence.MoviesRepository;
import com.osmaga.movies.dynamo.entity.MovieId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository repository;

    public List<Movie> listAllMovies() {
        Iterable<Movie> movies = repository.findAll();
    
        List<Movie> result = new ArrayList<>();
        movies.forEach(result :: add);
        
        return result;
    }

    public Movie createMovie(final Movie movie) {
        return repository.save(movie);
    }
    
    public Movie getMovie(final String title, final LocalDate releaseDate) {
        Optional<Movie> movieOptional = repository.findById(new MovieId(title, releaseDate));
        return movieOptional.get();
    }
    
    public List<Movie> getMoviesByTitle(final String title) {
        return repository.findByTitle(title);
    }
    
    public void deleteMovie(final String title, final LocalDate releaseDate) {
        repository.deleteById(new MovieId(title, releaseDate));
    }
}