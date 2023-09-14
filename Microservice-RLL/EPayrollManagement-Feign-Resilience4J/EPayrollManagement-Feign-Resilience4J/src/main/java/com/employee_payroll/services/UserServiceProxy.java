package com.employee_payroll.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.employee_payroll.entities.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "user-service")
public interface UserServiceProxy {

	@Retry(name = "user-service")
	@CircuitBreaker(name = "user-service", fallbackMethod = "fallbackMethodRegister")
	@PostMapping("/users/register")
	public ResponseEntity<?> register(@RequestBody User credentials);

	@Retry(name = "user-service")
	@CircuitBreaker(name = "user-service", fallbackMethod = "fallbackMethodLogin")
	@PostMapping("/users/login")
	public Object login(@RequestBody User credentials);

	default ResponseEntity<?> fallbackMethodRegister(@RequestBody User credentials, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		return ResponseEntity.notFound().build();
	}

	default void fallbackMethodLogin(@RequestBody User credentials, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
	}
}