package com.osmaga.movies.dynamo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.util.List;

@DynamoDBDocument
public class MovieDetails {

	private List<String> originCountries;
	private List<String> languages;
	private String aka;
	
	public List<String> getOriginCountries() {
		return originCountries;
	}
	
	public void setOriginCountries(List<String> originCountries) {
		this.originCountries = originCountries;
	}
	
	public List<String> getLanguages() {
		return languages;
	}
	
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	
	public String getAka() {
		return aka;
	}
	
	public void setAka(String aka) {
		this.aka = aka;
	}
}
