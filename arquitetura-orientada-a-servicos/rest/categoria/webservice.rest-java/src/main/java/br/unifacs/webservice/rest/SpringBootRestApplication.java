package br.unifacs.webservice.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
		
		System.out.println("Servidor no ar com spring boot em: http://localhost:8080/categoria");
	}

}
