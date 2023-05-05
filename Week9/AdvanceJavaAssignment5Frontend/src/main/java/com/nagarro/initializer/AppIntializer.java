package com.nagarro.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AppIntializer {

	public static void main(String[] args) {
		SpringApplication.run(AppIntializer.class, args);
	}
	
}
