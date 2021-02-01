package com.epam.streamPOC.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epam.streamPOC.dao.InMemoryMovieDao;
import com.epam.streamPOC.dao.InMemoryWorldDao;
import com.epam.streamPOC.dao.MovieDao;

@Configuration
public class BeansConfig {

	@Bean
	@Scope("singleton")
	public InMemoryWorldDao getWorldData() {
		return InMemoryWorldDao.getInstance();
	}
	
	@Bean
	@Scope("singleton")
	public MovieDao getMovieData() {
		return InMemoryMovieDao.getInstance();
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
