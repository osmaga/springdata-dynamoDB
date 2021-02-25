package com.osmaga.movies.dynamo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.osmaga.movies.dynamo.entity.converter.LocalDateConverter;

import java.time.LocalDate;

public class MovieId {
	
	private String title;
	private LocalDate releaseDate;
	
	public MovieId() {
	}
	
	public MovieId(String title, LocalDate releaseDate) {
		this.title = title;
		this.releaseDate = releaseDate;
	}
	
	@DynamoDBHashKey(attributeName = "title")
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@DynamoDBRangeKey(attributeName = "release_date")
	@DynamoDBTypeConverted(converter = LocalDateConverter.class)
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
}
