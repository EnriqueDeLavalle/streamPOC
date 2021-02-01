package com.epam.streamPOC.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

	private Predicate<City> isCapital = city -> worldData.findAllCountries().stream()
			.filter(c -> c.getCapital() == city.getId()).findFirst().isPresent();

	private Function<City, String> getCountryContinent = city -> worldData.findCountryByCode(city.getCountryCode())
			.getContinent();

	@Override
	public List<City> highestPopulatedByCountry() throws Exception {
		return worldData.findAllCities().stream()
				.collect(Collectors.groupingBy(City::getCountryCode,
						Collectors.maxBy(Comparator.comparingInt(City::getPopulation))))
				.values().stream().map(Optional::get).collect(Collectors.toList());
	}

	@Override
	public List<City> highestPopulatedByContinent() throws Exception {
		return worldData.findAllCities().stream()
				.collect(Collectors.groupingBy(getCountryContinent,
						Collectors.maxBy(Comparator.comparingInt(City::getPopulation))))
				.values().stream().map(Optional::get).collect(Collectors.toList());
	}

	@Override
	public City highestPopulatedCapitalCity() throws Exception {
		return worldData.findAllCities().stream().filter(c -> isCapital.test(c))
				.max((c1, c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation())).get();
	}

	@Override
	public List<City> highestPopulatedCapByContinent() throws Exception {
		return worldData.findAllCities().stream().filter(c -> isCapital.test(c))
				.collect(Collectors.groupingBy(getCountryContinent,
						Collectors.maxBy(Comparator.comparingInt(City::getPopulation))))
				.values().stream().map(Optional::get).collect(Collectors.toList());
	}

	@Override
	public List<Country> countriesByCityNumberDesc() throws Exception {
		return worldData.findAllCountries().stream()
				.sorted((c1, c2) -> Integer.compare(c2.getCities().size(), c1.getCities().size()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Country> countriesByPopulationDesc() throws Exception {
		return worldData.findAllCountries().stream().filter(c -> c.getPopulation() > 0)
				.sorted((c1, c2) -> Integer.compare(c2.getPopulation(), c1.getPopulation()))
				.collect(Collectors.toList());
	}

}
