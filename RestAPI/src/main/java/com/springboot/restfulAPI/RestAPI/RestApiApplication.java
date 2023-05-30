package com.springboot.restfulAPI.RestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfig(){
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
		};
	}
}
