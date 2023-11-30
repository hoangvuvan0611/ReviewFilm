package com.example.reviewfilm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;

@SpringBootApplication
public class ReviewFilmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewFilmApplication.class, args);
	}
}
