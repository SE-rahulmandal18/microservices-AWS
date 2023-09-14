package com.employee_payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ToDoMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoMicroServiceApplication.class, args);
	}

}
