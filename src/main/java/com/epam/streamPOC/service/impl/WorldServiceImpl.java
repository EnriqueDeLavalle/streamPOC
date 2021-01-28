package com.epam.streamPOC.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.streamPOC.dao.InMemoryWorldDao;
import com.epam.streamPOC.domain.City;
import com.epam.streamPOC.domain.Country;
import com.epam.streamPOC.service.WorldService;

@Service
public class WorldServiceImpl implements WorldService {

	@Autowired
	private InMemoryWorldDao worldData;

	@Override
	public List<City> highestPopulatedByCountry() {
		return null;
	}

	@Override
	public List<City> highestPopulatedByContinent() {
		return null;
	}

	@Override
	public List<City> highestPopulatedCap() {
		return null;
	}

	@Override
	public List<City> highestPopulatedCapByContinent() {
		return null;
	}

	@Override
	public List<Country> countriesByCityNumberDesc() {
		return worldData.findAllCountries();
	}

	@Override
	public List<Country> countriesByPopulationDesc() {
		return worldData.findAllCountries();
	}

}
