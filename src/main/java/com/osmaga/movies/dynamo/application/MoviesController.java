package com.osmaga.movies.dynamo.application;

import com.osmaga.movies.dynamo.entity.Movie;
import com.osmaga.movies.dynamo.service.MoviesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MoviesController {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	MoviesService service;
	
	@GetMapping("/movies")
	public ResponseEntity listMovies() {
		LOGGER.info("listMovies");
		List<Movie> movies = service.listAllMovies();
		ResponseEntity response = new ResponseEntity(movies, HttpStatus.OK);
		return response;
	}
	
	@PostMapping(value = "/movie", consumes = "application/json")
	public ResponseEntity createMovie(@RequestBody final Movie movie) {
		
		LOGGER.info("createMovie, movie={}", movie);
		service.createMovie(movie);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/movie/{movieTitle}/{releaseDate}")
	public ResponseEntity getMovieByTitleAndReleaseDate(@PathVariable(value = "movieTitle") final String movieTitle,
														@PathVariable(value = "releaseDate") @DateTimeFormat(iso =
																DateTimeFormat.ISO.DATE) final LocalDate releaseDate) {
		LOGGER.info("getMovieByTitleAndReleaseDate");
		Movie movie = service.getMovie(movieTitle, releaseDate);
		ResponseEntity response = new ResponseEntity(movie, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/movie/{movieTitle}")
	public ResponseEntity getMovieByTitle(@PathVariable(value = "movieTitle") final String movieTitle) {
		LOGGER.info("getMovieByTitle");
		List<Movie> movies = service.getMoviesByTitle(movieTitle);
		ResponseEntity response = new ResponseEntity(movies, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/movie/{movieTitle}/{releaseDate}")
	public ResponseEntity deleteMovieByTitleAndReleaseDate(@PathVariable(value = "movieTitle") final String movieTitle,
														@PathVariable(value = "releaseDate") @DateTimeFormat(iso =
																DateTimeFormat.ISO.DATE) final LocalDate releaseDate) {
		LOGGER.info("deleteMovieByTitleAndReleaseDate");
		service.deleteMovie(movieTitle, releaseDate);
		ResponseEntity response = new ResponseEntity(HttpStatus.OK);
		return response;
	}
}
