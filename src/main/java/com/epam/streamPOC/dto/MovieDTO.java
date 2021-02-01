package com.epam.streamPOC.dto;

import java.util.List;

import com.epam.streamPOC.domain.Genre;

public class MovieDTO {

	private int id;
	private String title;
	private int year;
	private String imdb;
	private List<Genre> genres;

	public MovieDTO() {
	}

	public MovieDTO(int id, String title, int year, String imdb, List<Genre> genres) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.imdb = imdb;
		this.genres = genres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}
	
	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

}
