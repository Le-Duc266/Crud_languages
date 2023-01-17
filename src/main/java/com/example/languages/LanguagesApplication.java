package com.example.languages;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class LanguagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LanguagesApplication.class, args);
	}

	@Bean
	public OpenAPI openApiConfig() {
		return new OpenAPI().info(info());
	}

	private Info info() {
		Info info = new Info();

		info.title("Languages API").description("CRUD API").version("1.0.0");
		return info;
	}


}
