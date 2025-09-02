package com.ekibiina.ekibiina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class EkibiinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkibiinaApplication.class, args);
	}

	@GetMapping
	public String helloWorld() {
		return "Backend works";
	}
}
