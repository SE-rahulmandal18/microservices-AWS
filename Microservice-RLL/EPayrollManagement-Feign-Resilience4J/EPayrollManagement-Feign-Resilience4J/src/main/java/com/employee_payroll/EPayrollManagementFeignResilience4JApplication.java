package com.employee_payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;


@EnableFeignClients
@SpringBootApplication
public class EPayrollManagementFeignResilience4JApplication {

	public static void main(String[] args) {
		SpringApplication.run(EPayrollManagementFeignResilience4JApplication.class, args);
	}
	
	@Bean
	public Sampler alwaysSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
