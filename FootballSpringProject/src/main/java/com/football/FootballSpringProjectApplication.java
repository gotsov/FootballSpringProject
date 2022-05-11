package com.football;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.football.models"})
public class FootballSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballSpringProjectApplication.class, args);
	}

}
