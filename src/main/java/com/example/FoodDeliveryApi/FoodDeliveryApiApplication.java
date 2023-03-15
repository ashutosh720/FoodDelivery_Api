package com.example.FoodDeliveryApi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class FoodDeliveryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryApiApplication.class, args);
	}

}
