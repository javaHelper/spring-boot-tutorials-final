package com.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

@Configuration
public class DatabaseConfig {
	@Autowired
	private Environment env;

	@Bean(name="secondaryDS")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource getPrimaryBatchDataSource(){
		return DataSourceBuilder.create()
				.url(env.getProperty("spring.datasource.url"))
				.driverClassName(env.getProperty("spring.datasource.driver-class-name"))
				.username(env.getProperty("spring.datasource.username"))
				.password(env.getProperty("spring.datasource.password"))
				.build();
	}

	@Bean(name="primaryDS")
	@Primary
	@ConfigurationProperties(prefix="spring.hello.datasource")
	public DataSource getSeconadaryBatchDataSource(){
		return DataSourceBuilder.create()
				.url(env.getProperty("spring.hello.datasource.url"))
				.driverClassName(env.getProperty("spring.hello.datasource.driver-class-name"))
				.username(env.getProperty("spring.hello.datasource.username"))
				.password(env.getProperty("spring.hello.datasource.password"))
				.build();
	}
}
