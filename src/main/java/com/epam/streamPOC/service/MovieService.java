package com.epam.streamPOC.service;

import java.util.List;

import com.epam.streamPOC.domain.Movie;
import com.epam.streamPOC.dto.DirectorDTO;

public interface MovieService {

	List<DirectorDTO> directorsNumberMoviesAndGenres();

	List<Movie> moviesByYears();

	List<Movie> moviesByGenres();

}
