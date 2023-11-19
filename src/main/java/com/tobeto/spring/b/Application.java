package com.tobeto.spring.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// localhost:8081/api/persons

// Annotation
// atandığı argümana özellik kazandırır

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// springi devreye alır
		SpringApplication.run(Application.class, args);
	}

}
