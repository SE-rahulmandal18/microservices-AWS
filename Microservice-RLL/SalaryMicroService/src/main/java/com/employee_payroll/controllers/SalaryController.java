package com.employee_payroll.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee_payroll.DTO.SalaryDTO;
import com.employee_payroll.entities.Salary;
import com.employee_payroll.services.SalaryService;

@RestController
@RequestMapping("/salary")

public class SalaryController {

	@Autowired
	SalaryService salaryService;

	@GetMapping("/all")
	public List<SalaryDTO> getAllSalary() {
		return salaryService.getAllSalary();
	}

	@GetMapping("/{salaryId}")
	public List<SalaryDTO> getById(@PathVariable int salaryId) {
		return salaryService.getByIdSalary(salaryId);
	}

	@GetMapping("/employee/{employee_id}")
	public List<SalaryDTO> getByEmployeeId(@PathVariable int employee_id) {
		return salaryService.getSalaryByEmployeeId(employee_id);
	}

	@PutMapping("/{salaryId}")
	public void insertByInd(@PathVariable int salaryId, @RequestBody Salary salary) {
		salaryService.updatedSalary(salaryId, salary);
	}

	@PostMapping
	public void updateSalary(@RequestBody Salary salary) {
		salaryService.insertSalary(salary);
	}

	@DeleteMapping("/{salaryId}")
	public void deleteByIdSalary(@PathVariable int salaryId) {
		salaryService.deleteSalary(salaryId);
	}
}
