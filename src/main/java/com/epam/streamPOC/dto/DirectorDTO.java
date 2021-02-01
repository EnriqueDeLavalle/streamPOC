package com.epam.streamPOC.dto;

public class DirectorDTO {
	
	private int id;
	private String name;
	private String imdb;
	private long numberMovies;
	private long numberGenres;
	
	public DirectorDTO() {
		super();
	}

	public DirectorDTO(int id, String name, String imdb, long numberMovies, long numberGenres) {
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

	public long getNumberMovies() {
		return numberMovies;
	}

	public void setNumberMovies(long numberMovies) {
		this.numberMovies = numberMovies;
	}

	public long getNumberGenres() {
		return numberGenres;
	}

	public void setNumberGenres(long numberGenres) {
		this.numberGenres = numberGenres;
	}
	
}
