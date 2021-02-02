package com.epam.streamPOC.service.impl;

import com.epam.streamPOC.dao.MovieDao;
import com.epam.streamPOC.domain.Director;
import com.epam.streamPOC.domain.Movie;
import com.epam.streamPOC.dto.DirectorDTO;
import com.epam.streamPOC.dto.MovieDTO;
import com.epam.streamPOC.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    Predicate<MovieDTO> isDramaComedy = movie -> movie.getGenres().stream()
            .anyMatch(g -> Arrays.asList(1, 2).contains(g.getId()));
    BiPredicate<Movie, DirectorDTO> isDirector = (movie, director) -> movie.getDirectors().stream()
            .anyMatch(d -> d.getId() == director.getId());
    @Autowired
    private MovieDao movieDao;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<DirectorDTO> directorsNumberMoviesAndGenres() {
        return movieDao.findAllDirectors().stream()
                .map(this::convertDirectorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> moviesByDramaComedy() {
        return movieDao.findAllMovies().stream()
                .map(this::convertMovieDTO)
                .filter(isDramaComedy)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<MovieDTO>> moviesByYears() {
        return new TreeMap<>(movieDao.findAllMovies().stream()
                .map(this::convertMovieDTO)
                .collect(Collectors.groupingBy(MovieDTO::getYear)));

    }

    private MovieDTO convertMovieDTO(Movie movie) {
        return mapper.map(movie, MovieDTO.class);
    }

    private DirectorDTO convertDirectorDTO(Director director) {
        DirectorDTO directorDTO = mapper.map(director, DirectorDTO.class);
        directorDTO.setNumberMovies(numberDirMovies(directorDTO));
        directorDTO.setNumberGenres(numberDirGenres(directorDTO));
        return directorDTO;
    }

    private long numberDirMovies(DirectorDTO director) {
        return movieDao.findAllMovies().stream()
                .filter(m -> isDirector.test(m, director)).count();
    }

    private long numberDirGenres(DirectorDTO director) {
        return movieDao.findAllMovies().stream()
                .filter(m -> isDirector.test(m, director))
                .map(Movie::getGenres)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet()).size();
    }

}
