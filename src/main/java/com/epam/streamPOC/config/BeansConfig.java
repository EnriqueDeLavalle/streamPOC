package com.epam.streamPOC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epam.streamPOC.dao.InMemoryWorldDao;

@Configuration
public class BeansConfig {

	@Bean
	@Scope("singleton")
	public InMemoryWorldDao getWorldData() {
		return InMemoryWorldDao.getInstance();
	}

}
