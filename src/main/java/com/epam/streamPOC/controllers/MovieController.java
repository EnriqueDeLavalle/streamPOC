package com.epam.streamPOC.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@GetMapping("/test")
	public ResponseEntity<String> getTest() {
		return new ResponseEntity<>("OK: ", HttpStatus.OK);
	}

}
