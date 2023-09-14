package com.employee_payroll.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.employee_payroll.DTO.EmployeeDTO;
import com.employee_payroll.entities.Employee;
import com.employee_payroll.services.EmployeeServiceProxy;

import java.util.List;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceProxy employeeServiceProxy;
	
	private Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping("/get-employee/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id) {
		
		log.debug("In getAllEmployees");
		ResponseEntity<?> employee = employeeServiceProxy.getEmployee(id);
		log.debug("In getEmployee with return value Todo: " + employee);
		
		return employee;
	}

	@GetMapping("/get-employee")
	public List<Employee> getAllEmployees() {
		
		log.debug("In getAllEmployees");
		List<Employee> employee = employeeServiceProxy.getAllEmployees();
		log.debug("In getAllEmployee with return value Todo: " + employee);
		
		return employee;
	}

	@PostMapping("/post-employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		
		return employeeServiceProxy.createEmployee(employee);
	}

	@PutMapping("/put-employee/{id}")
	public void updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDetails) {
		employeeServiceProxy.updateEmployee(id, employeeDetails);
	}

	@DeleteMapping("/delete-employee/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeServiceProxy.deleteEmployee(id);
	}
}
