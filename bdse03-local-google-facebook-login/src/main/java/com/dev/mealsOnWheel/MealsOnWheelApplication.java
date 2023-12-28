package com.dev.mealsOnWheel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.dev.mealsOnWheel.configuration.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties (AppProperties.class)
public class MealsOnWheelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealsOnWheelApplication.class, args);
	}

}
