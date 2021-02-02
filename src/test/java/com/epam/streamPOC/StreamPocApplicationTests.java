package com.epam.streamPOC;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.epam.streamPOC.domain.City;
import com.epam.streamPOC.domain.Country;
import com.epam.streamPOC.dto.DirectorDTO;
import com.epam.streamPOC.dto.MovieDTO;
import com.epam.streamPOC.service.MovieService;
import com.epam.streamPOC.service.WorldService;

@SpringBootTest
class StreamPocApplicationTests {

	@Autowired
	private MovieService movieService;

	@Autowired
	private WorldService worldService;

	@Test
	void contextLoads() {
	}

	@Test
	public void highestPopulatedByCountryTest() {
		// given
		List<City> cities = new ArrayList<City>();
		City city1 = new City(3494, "Auckland", "NZL", 381800);
		City city2 = new City(2928, "Warszawa", "POL", 1615369);
		// when
		try {
			cities = worldService.highestPopulatedByCountry();
		} catch (Exception e) {
		}
		// then
		assertEquals(cities.stream().filter(c -> c.getId() == 3494).findFirst().get().getCountryCode(),
				city1.getCountryCode());
		assertEquals(cities.stream().filter(c -> c.getId() == 3494).findFirst().get().getPopulation(),
				city1.getPopulation());

		assertEquals(cities.stream().filter(c -> c.getId() == 2928).findFirst().get().getCountryCode(),
				city2.getCountryCode());
		assertEquals(cities.stream().filter(c -> c.getId() == 2928).findFirst().get().getPopulation(),
				city2.getPopulation());
	}

	@Test
	public void highestPopulatedByContinentTest() {
		// given
		List<City> cities = new ArrayList<City>();
		City city1 = new City(3580, "Moscow", "RUS", 8389200);
		City city2 = new City(130, "Sydney", "AUS", 3276207);
		// when
		try {
			cities = worldService.highestPopulatedByContinent();
		} catch (Exception e) {
		}
		// then
		assertEquals(cities.stream().filter(c -> c.getId() == 3580).findFirst().get().getCountryCode(),
				city1.getCountryCode());
		assertEquals(cities.stream().filter(c -> c.getId() == 3580).findFirst().get().getPopulation(),
				city1.getPopulation());

		assertEquals(cities.stream().filter(c -> c.getId() == 130).findFirst().get().getCountryCode(),
				city2.getCountryCode());
		assertEquals(cities.stream().filter(c -> c.getId() == 130).findFirst().get().getPopulation(),
				city2.getPopulation());
	}

	@Test
	public void highestPopulatedCapitalCityTest() {
		// given
		City city1 = new City(2331, "Seoul", "KOR", 9981619);
		City capitalCity = new City();
		// when
		try {
			capitalCity = worldService.highestPopulatedCapitalCity();
		} catch (Exception e) {
		}
		// then
		assertEquals(capitalCity.getCountryCode(), city1.getCountryCode());
		assertEquals(capitalCity.getPopulation(), city1.getPopulation());
	}

	@Test
	public void highestPopulatedCapByContinentTest() {
		// given
		List<City> cities = new ArrayList<City>();
		City city1 = new City(2890, "Lima", "PER", 6464693);
		City city2 = new City(135, "Canberra", "AUS", 322723);
		// when
		try {
			cities = worldService.highestPopulatedCapByContinent();
		} catch (Exception e) {
		}
		// then
		assertEquals(cities.stream().filter(c -> c.getId() == 2890).findFirst().get().getCountryCode(),
				city1.getCountryCode());
		assertEquals(cities.stream().filter(c -> c.getId() == 2890).findFirst().get().getPopulation(),
				city1.getPopulation());

		assertEquals(cities.stream().filter(c -> c.getId() == 135).findFirst().get().getCountryCode(),
				city2.getCountryCode());
		assertEquals(cities.stream().filter(c -> c.getId() == 135).findFirst().get().getPopulation(),
				city2.getPopulation());
	}

	@Test
	public void countriesByCityNumberDescTest() {
		// given
		List<Country> countriesSorted = new ArrayList<Country>();
		// when
		try {
			countriesSorted = worldService.countriesByCityNumberDesc();
		} catch (Exception e) {
		}
		// then
		assertThat(countriesSorted.get(0).getCities().size() > countriesSorted.get(1).getCities().size());
	}

	@Test
	public void countriesByPopulationDescTest() {
		// given
		List<Country> countriesSorted = new ArrayList<Country>();
		// when
		try {
			countriesSorted = worldService.countriesByPopulationDesc();
		} catch (Exception e) {
		}
		// then
		assertThat(countriesSorted.get(0).getPopulation() > countriesSorted.get(1).getPopulation());
		assertThat(countriesSorted.get(1).getPopulation() > countriesSorted.get(2).getPopulation());
	}

	@Test
	public void directorsNumberMoviesAndGenresTest() {

		// given
		DirectorDTO director = new DirectorDTO(95, "Ki-duk Kim", "nm1104118", 5, 5);

		// when
		List<DirectorDTO> result = movieService.directorsNumberMoviesAndGenres();

		// then
		DirectorDTO oneDirectorfound = result.stream().filter(d -> d.getId() == 95).findFirst().get();
		assertEquals(oneDirectorfound.getId(), director.getId());
		assertEquals(oneDirectorfound.getNumberGenres(), director.getNumberGenres());
		assertEquals(oneDirectorfound.getNumberMovies(), director.getNumberMovies());
	}

	@Test
	public void moviesByDramaComedyTest() {
		// given
		Predicate<MovieDTO> isDramaComedy = movie -> movie.getGenres().stream()
				.filter(g -> Arrays.asList(1, 2).contains(g.getId())).findAny().isPresent();

		// when
		List<MovieDTO> movies = movieService.moviesByDramaComedy();

		// then
		assertTrue(isDramaComedy.test(movies.get(0)));
		assertTrue(isDramaComedy.test(movies.get(5)));
		assertTrue(isDramaComedy.test(movies.get(175)));
	}

	@Test
	public void moviesByYearsTest() {

		// given

		// when
		Map<Integer, List<MovieDTO>> moviesByYear = movieService.moviesByYears();

		// then
		assertEquals(moviesByYear.get(1940).size(), 1);
		assertEquals(moviesByYear.get(1954).size(), 3);
		assertEquals(moviesByYear.get(1983).size(), 4);
		assertEquals(moviesByYear.get(1983).size(), 4);
		assertEquals(moviesByYear.get(2003).size(), 5);
	}

}
