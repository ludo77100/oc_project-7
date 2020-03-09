package org.ludo.bibliotheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
@EnableSwagger2
public class BibliothequeApplication {

	private static final Logger logger = LogManager.getLogger(BibliothequeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BibliothequeApplication.class, args);
		logger.debug("Microservice Bibliothèque démarré");
			}

}
