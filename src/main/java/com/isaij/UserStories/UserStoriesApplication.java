package com.isaij.UserStories;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class UserStoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserStoriesApplication.class, args);
	}

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("User Stories Manager API")
						.description("Web Application for managing user stories.")
						.version("1.0.0")
						.license(new License().name("Isai Jimenez Talonia").url("isaijimeneztalonia34@gmail.com")));
	}


}
