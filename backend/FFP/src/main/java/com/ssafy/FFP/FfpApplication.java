package com.ssafy.FFP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FfpApplication {

	public static final String APPLICATION_LOCATIONS = "spring.config.location="
			+ "classpath:application.properties,"
			+ "classpath:security.yml";

	public static void main(String[] args) {

		new SpringApplicationBuilder(FfpApplication.class)
				.properties(APPLICATION_LOCATIONS)
				.run(args);
//		SpringApplication.run(EmotionPlanetApplication.class, args);
	}

}
