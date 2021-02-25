package com.osmaga.movies.dynamo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.osmaga.movies.dynamo.entity.converter.LocalDateConverter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@DynamoDBTable(tableName = "Movies")
public class Movie {
	
	@Id
	private MovieId movieId;
	
	private String plot;
	private String director;
	private int length;
	private boolean seen;
	private MovieDetails details;
	
	
	public Movie() {
	}
	
	public Movie(MovieId movieId) {
		this.movieId = movieId;
	}
	
	@DynamoDBHashKey(attributeName = "title")
	public String getTitle() {
		return movieId != null ? movieId.getTitle() : null;
	}
	
	public void setTitle(String title) {
		if (this.movieId == null) {
			this.movieId = new MovieId();
		}
		this.movieId.setTitle(title);
	}
	
	@DynamoDBRangeKey(attributeName = "release_date")
	@DynamoDBTypeConverted(converter = LocalDateConverter.class)
	public LocalDate getReleaseDate() {
		return movieId != null ? movieId.getReleaseDate() : null;
	}
	
	public void setReleaseDate(LocalDate releaseDate) {
		if (this.movieId == null) {
			this.movieId = new MovieId();
		}
		this.movieId.setReleaseDate(releaseDate);
	}
	
	@DynamoDBAttribute(attributeName = "plot")
	public String getPlot() {
		return plot;
	}
	
	public void setPlot(String plot) {
		this.plot = plot;
	}
	
	@DynamoDBAttribute(attributeName = "director")
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	@DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL)
	@DynamoDBAttribute(attributeName = "seen")
	public boolean isSeen() {
		return seen;
	}
	
	public void setSeen(boolean seen) {
		this.seen = seen;
	}
	
	@DynamoDBAttribute(attributeName = "length")
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	@DynamoDBAttribute(attributeName = "details")
	public MovieDetails getDetails() {
		return details;
	}
	
	public void setDetails(MovieDetails details) {
		this.details = details;
	}
	
	@Override
	public String toString() {
		return String.format("[title=%s, releaseDate=%s]", getTitle(), getReleaseDate());
	}
}
