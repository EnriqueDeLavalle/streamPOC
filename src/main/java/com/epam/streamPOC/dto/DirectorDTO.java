package com.epam.streamPOC.dto;

public class DirectorDTO {
	
	private int id;
	private String name;
	private String imdb;
	private int numberMovies;
	private int numberGenres;
	
	public DirectorDTO() {
		super();
	}

	public DirectorDTO(int id, String name, String imdb, int numberMovies, int numberGenres) {
		super();
		this.id = id;
		this.name = name;
		this.imdb = imdb;
		this.numberMovies = numberMovies;
		this.numberGenres = numberGenres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public int getNumberMovies() {
		return numberMovies;
	}

	public void setNumberMovies(int numberMovies) {
		this.numberMovies = numberMovies;
	}

	public int getNumberGenres() {
		return numberGenres;
	}

	public void setNumberGenres(int numberGenres) {
		this.numberGenres = numberGenres;
	}
	
}
