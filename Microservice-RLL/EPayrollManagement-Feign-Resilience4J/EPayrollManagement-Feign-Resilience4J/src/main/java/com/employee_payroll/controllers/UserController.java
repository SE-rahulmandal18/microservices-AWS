package com.employee_payroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.employee_payroll.entities.User;
import com.employee_payroll.services.UserServiceProxy;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserServiceProxy userServiceProxy;

	@PostMapping("/users/register")
	public ResponseEntity<?> register(@RequestBody User credentials) {
		return userServiceProxy.register(credentials);
	}

	@PostMapping("/users/login")
	public void login(@RequestBody User credentials) {
		userServiceProxy.login(credentials);
	}
}