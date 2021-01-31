package com.epam.streamPOC.service;

import java.util.List;

import com.epam.streamPOC.domain.City;
import com.epam.streamPOC.domain.Country;

public interface WorldService {

	List<City> highestPopulatedByCountry() throws Exception;

	List<City> highestPopulatedByContinent() throws Exception;

	City highestPopulatedCapitalCity() throws Exception;

	List<City> highestPopulatedCapByContinent() throws Exception;

	List<Country> countriesByCityNumberDesc() throws Exception;

	List<Country> countriesByPopulationDesc() throws Exception;

	String test() throws Exception;

}
