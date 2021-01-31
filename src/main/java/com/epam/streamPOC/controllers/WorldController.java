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
		return new ResponseEntity<>("OK: ", HttpStatus.OK);
	}

	@GetMapping("/city/highestPopulatedByCountry")
	public ResponseEntity<List<City>> highestPopulatedByCountry() {

		try {
			List<City> response = worldService.highestPopulatedByCountry();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/city/highestPopulatedByContinent")
	public ResponseEntity<List<City>> highestPopulatedByContinent() {
		try {
			List<City> response = worldService.highestPopulatedByContinent();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/city/highestPopulatedCapitalCity")
	public ResponseEntity<City> highestPopulatedCap() {
		try {
			City response = worldService.highestPopulatedCapitalCity();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/city/highestPopulatedCapByContinent")
	public ResponseEntity<List<City>> highestPopulatedCapByContinent() {
		try {
			List<City> response = worldService.highestPopulatedCapByContinent();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/country/countriesByCityNumberDesc")
	public ResponseEntity<List<Country>> countriesByCityNumberDesc() {
		try {
			List<Country> response = worldService.countriesByCityNumberDesc();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/country/countriesByPopulationDesc")
	public ResponseEntity<List<Country>> countriesByPopulationDesc() {
		try {
			List<Country> response = worldService.countriesByPopulationDesc();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
