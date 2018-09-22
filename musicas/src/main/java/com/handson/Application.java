package com.handson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.handson.repository.MusicasRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "com.handson" }, basePackageClasses = { MusicasRepository.class } )
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
