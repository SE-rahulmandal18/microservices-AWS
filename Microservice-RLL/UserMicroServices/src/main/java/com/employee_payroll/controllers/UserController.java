package com.employee_payroll.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee_payroll.entities.User;
import com.employee_payroll.entities.Employee;
import com.employee_payroll.repositories.UserRepo;
import com.employee_payroll.repositories.EmployeeRepo;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserRepo credentialsRepo;

	@Autowired
	private EmployeeRepo employeeRepo;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User credentials) {
		Optional<Employee> employee = employeeRepo.findById(credentials.getEmployee().getId());
		if (employee.isPresent()) {
			credentials.setEmployee(employee.get());
			credentialsRepo.save(credentials);
			return ResponseEntity.status(HttpStatus.CREATED).body("Registered successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee not found, Registration failed");
		}
	}

	@PostMapping("/login")
	public Object login(@RequestBody User credentials) {
		List<User> allAccounts = credentialsRepo.findAll();
		ResponseEntity<?> loggedIn = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Account Not Found");

		for (User accountDetails : allAccounts) {
			if (accountDetails.getEmployee().getId() == credentials.getEmployee().getId()
					&& accountDetails.getPassword().equals(credentials.getPassword())) {
				loggedIn = ResponseEntity.status(HttpStatus.ACCEPTED).body(accountDetails.getEmployee().getId());
				break;
			}
		}
		return loggedIn.getBody();
	}

}
