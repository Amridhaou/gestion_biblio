package com.gestion_biblio.gestion_biblio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Biblio APIs", version = "1.0", description = "Gestion Bibliotheque"))
public class GestionBiblioApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestionBiblioApplication.class, args);
	}

}
