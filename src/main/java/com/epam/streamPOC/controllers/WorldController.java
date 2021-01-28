package com.epam.streamPOC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.streamPOC.domain.City;
import com.epam.streamPOC.domain.Country;
import com.epam.streamPOC.service.impl.WorldServiceImpl;

@RestController
@RequestMapping("/world")
public class WorldController {
	
	@Autowired
	private WorldServiceImpl worldService;


	@GetMapping("/test")
	public ResponseEntity<String> getTest() {
		return new ResponseEntity<>("OK: " , HttpStatus.OK);
	}

	@GetMapping("/highestPopulated1")
	public ResponseEntity<List<City>> highestPopulatedByCountry() {
		return new ResponseEntity<>(worldService.highestPopulatedByCountry(), HttpStatus.OK);
	}

	@GetMapping("/highestPopulated2")
	public ResponseEntity<List<City>> highestPopulatedByContinent() {
		return new ResponseEntity<>(worldService.highestPopulatedByContinent(), HttpStatus.OK);
	}

	@GetMapping("/highestPopulated3")
	public ResponseEntity<List<City>> highestPopulatedCap() {
		return new ResponseEntity<>(worldService.highestPopulatedCap(), HttpStatus.OK);
	}

	@GetMapping("/highestPopulated4")
	public ResponseEntity<List<City>> highestPopulatedCapByContinent() {
		return new ResponseEntity<>(worldService.highestPopulatedCapByContinent(), HttpStatus.OK);
	}

	@GetMapping("/countriesByCity")
	public ResponseEntity<List<Country>> countriesByCityNumberDesc() {
		return new ResponseEntity<>(worldService.countriesByCityNumberDesc(), HttpStatus.OK);
	}

	@GetMapping("/countriesByPop")
	public ResponseEntity<List<Country>> countriesByPopulationDesc() {
		return new ResponseEntity<>(worldService.countriesByPopulationDesc(), HttpStatus.OK);
	}

}
