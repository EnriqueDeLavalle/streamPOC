package com.epam.streamPOC.service;

import java.util.List;
import java.util.Map;

import com.epam.streamPOC.dto.DirectorDTO;
import com.epam.streamPOC.dto.MovieDTO;

public interface MovieService {

	List<DirectorDTO> directorsNumberMoviesAndGenres();

	List<MovieDTO> moviesByDramaComedy();

	Map<Integer, List<MovieDTO>> moviesByYears();

}
