package com.employee_payroll.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee_payroll.DTO.SalaryDTO;
import com.employee_payroll.entities.Salary;
import com.employee_payroll.services.SalaryService;

@RestController
@RequestMapping("/salary") // Set the base path for the controller
@CrossOrigin(origins = "*")
public class SalaryController {

	@Autowired
	SalaryService salaryService;

	@GetMapping("/all") // Relative path within the base path
	public List<SalaryDTO> getAllSalary() {
		return salaryService.getAllSalary();
	}

	@GetMapping("/{salaryId}") // Relative path within the base path
	public List<SalaryDTO> getById(@PathVariable int salaryId) {
		return salaryService.getByIdSalary(salaryId);
	}

	@GetMapping("/employee/{employee_id}") // Relative path within the base path
	public List<SalaryDTO> getByEmployeeId(@PathVariable int employee_id) {
		return salaryService.getSalaryByEmployeeId(employee_id);
	}

	@PutMapping("/{salaryId}") // Relative path within the base path
	public void insertByInd(@PathVariable int salaryId, @RequestBody Salary salary) {
		salaryService.updatedSalary(salaryId, salary);
	}

	@PostMapping // Relative path within the base path
	public void updateSalary(@RequestBody Salary salary) {
		salaryService.insertSalary(salary);
	}

	@DeleteMapping("/{salaryId}") // Relative path within the base path
	public void deleteByIdSalary(@PathVariable int salaryId) {
		salaryService.deleteSalary(salaryId);
	}
}
