package com.tcdNetflix.filmeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class FilmeserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmeserviceApplication.class, args);
	}

}
