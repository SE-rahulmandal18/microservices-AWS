package com.employee_payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EPayrollManagementEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EPayrollManagementEurekaServerApplication.class, args);
	}

}
