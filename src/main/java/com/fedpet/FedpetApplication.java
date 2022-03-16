package com.fedpet;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Fedpet",
		description = "Fedpet is the community build app for provide food for street animals through verious campains",
		version = "2.0"))
public class FedpetApplication {

	public static void main(String[] args) {
		SpringApplication.run(FedpetApplication.class, args);
	}

}

