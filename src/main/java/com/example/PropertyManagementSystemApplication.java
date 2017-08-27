package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
		basePackageClasses = { PropertyManagementSystemApplication.class, Jsr310JpaConverters.class }
)
@SpringBootApplication
@ComponentScan
public class PropertyManagementSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(PropertyManagementSystemApplication.class, args);
	}
}
