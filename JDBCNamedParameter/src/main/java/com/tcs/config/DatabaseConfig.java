package com.tcs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/school");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		NamedParameterJdbcTemplate jt = new NamedParameterJdbcTemplate(getDataSource());
		return jt;
	}

}
