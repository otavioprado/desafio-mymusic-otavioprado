package com.handson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.handson.repository.ArtistaRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "com.handson" }, basePackageClasses = { ArtistaRepository.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
