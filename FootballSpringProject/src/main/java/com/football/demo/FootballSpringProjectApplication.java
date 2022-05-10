package com.football.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class FootballSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballSpringProjectApplication.class, args);
	}

}
