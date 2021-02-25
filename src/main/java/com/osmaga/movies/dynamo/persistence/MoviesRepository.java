package com.osmaga.movies.dynamo.persistence;

import com.osmaga.movies.dynamo.entity.Movie;
import com.osmaga.movies.dynamo.entity.MovieId;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface MoviesRepository extends CrudRepository<Movie, MovieId> {
	
	List<Movie> findByTitle(final String title);
}