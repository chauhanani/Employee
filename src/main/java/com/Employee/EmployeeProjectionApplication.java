package com.Employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeProjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectionApplication.class, args);
	}

}
