package com.epam.streamPOC.service;

import java.util.List;

import com.epam.streamPOC.domain.City;
import com.epam.streamPOC.domain.Country;

public interface WorldService {

	List<City> highestPopulatedByCountry();

	List<City> highestPopulatedByContinent();

	List<City> highestPopulatedCap();

	List<City> highestPopulatedCapByContinent();
	
	List<Country> countriesByCityNumberDesc(); 
	
	List<Country> countriesByPopulationDesc();

}
