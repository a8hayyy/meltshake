package com.meltshaketeam.meltshake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MeltshakeApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(MeltshakeApplication.class, args);
	}
	
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**") // Allow CORS for all endpoints
	                .allowedOrigins("http://localhost:3000") // Allow requests from this origin
	                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow these HTTP methods
	                .allowedHeaders("*"); // Allow all headers
	    }

}
