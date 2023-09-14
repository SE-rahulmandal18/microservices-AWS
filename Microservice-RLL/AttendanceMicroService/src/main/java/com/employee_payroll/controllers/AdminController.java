package com.employee_payroll.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee_payroll.entities.AdminLoginRequest;

@RestController
public class AdminController {

	private static final String ADMIN_USERNAME = "admin";
	private static final String ADMIN_PASSWORD = "admin@123";

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/api/admin/login")
	public ResponseEntity<Object> adminLogin(@RequestBody AdminLoginRequest loginRequest) {
		if (loginRequest.getUsername().equals(ADMIN_USERNAME) && loginRequest.getPassword().equals(ADMIN_PASSWORD)) {
			return ResponseEntity.ok().body("{\"result\": \"success\"}");
		} else {
			return ResponseEntity.ok().body("{\"result\": \"failure\"}");
		}
	}
}