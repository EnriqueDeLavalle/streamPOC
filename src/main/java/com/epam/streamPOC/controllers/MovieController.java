package com.epam.streamPOC.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.streamPOC.dto.DirectorDTO;
import com.epam.streamPOC.dto.MovieDTO;
import com.epam.streamPOC.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/directorsNumberMoviesAndGenres")
	public ResponseEntity<List<DirectorDTO>> directorsNumberMoviesAndGenres() {
		try {
			return new ResponseEntity<>(movieService.directorsNumberMoviesAndGenres(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/moviesByDramaComedy")
	public ResponseEntity<List<MovieDTO>> moviesByDramaComedy() {

		try {
			return new ResponseEntity<>(movieService.moviesByDramaComedy(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/moviesByYears")
	public ResponseEntity<Map<Integer, List<MovieDTO>>> moviesByYears() {

		try {
			return new ResponseEntity<>(movieService.moviesByYears(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
