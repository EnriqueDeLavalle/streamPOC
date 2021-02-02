package com.epam.streamPOC.service.impl;

import com.epam.streamPOC.dao.InMemoryWorldDao;
import com.epam.streamPOC.domain.City;
import com.epam.streamPOC.domain.Country;
import com.epam.streamPOC.service.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class WorldServiceImpl implements WorldService {

    @Autowired
    private InMemoryWorldDao worldData;

    private Predicate<City> isCapital = city -> worldData.findAllCountries().stream()
            .anyMatch(c -> c.getCapital() == city.getId());

    private Function<City, String> getCountryContinent = city -> worldData.findCountryByCode(city.getCountryCode())
            .getContinent();

    @Override
    public List<City> highestPopulatedByCountry() {
        return new ArrayList<>(worldData.findAllCities().stream()
                .collect(Collectors.toMap(City::getCountryCode, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingInt(City::getPopulation))))
                .values());
    }

    @Override
    public List<City> highestPopulatedByContinent() {
        return new ArrayList<>(worldData.findAllCities().stream()
                .collect(Collectors.toMap(getCountryContinent, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingInt(City::getPopulation))))
                .values());
    }

    @Override
    public City highestPopulatedCapitalCity() {
        return worldData.findAllCities().stream()
                .filter(isCapital)
                .max(Comparator.comparingInt(City::getPopulation))
                .orElseThrow();
    }

    @Override
    public List<City> highestPopulatedCapByContinent() {
        return new ArrayList<>(worldData.findAllCities().stream()
                .filter(isCapital)
                .collect(Collectors.toMap(getCountryContinent, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingInt(City::getPopulation))))
                .values());
    }

    @Override
    public List<Country> countriesByCityNumberDesc() {
        return worldData.findAllCountries().stream()
                .sorted(Comparator.comparing(country -> country.getCities().size()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Country> countriesByPopulationDesc() {
        return worldData.findAllCountries().stream().filter(c -> c.getPopulation() > 0)
                .sorted(Comparator.comparing(Country::getPopulation))
                .collect(Collectors.toList());
    }

}
