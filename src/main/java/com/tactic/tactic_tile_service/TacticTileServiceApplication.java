package com.tactic.tactic_tile_service;

import com.tactic.tactic_tile_service.models.elements.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.tactic.tactic_tile_service.config.Singleton.thisElement;

@SpringBootApplication
public class TacticTileServiceApplication {

	public static void main(String[] args) {
		thisElement = new Element();
		thisElement.initialize();

		String[] settings = new String[1];
		settings[0] = "--server.port=" + thisElement.getSettings().getOrDefault("port","8099");

		SpringApplication.run(TacticTileServiceApplication.class, settings);
	}

}
