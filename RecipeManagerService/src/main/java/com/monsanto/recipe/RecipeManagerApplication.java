package com.monsanto.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class RecipeManagerApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		SpringApplicationBuilder springApplicationBuilder = application.sources(RecipeManagerApplication.class);
		application.main(RecipeManagerApplication.class);
		
		return springApplicationBuilder;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RecipeManagerApplication.class, args);
	}
}
