package com.example.askend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "filter")
@EntityScan(basePackages = "filter")
public class AskendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AskendApplication.class, args);
	}

}
