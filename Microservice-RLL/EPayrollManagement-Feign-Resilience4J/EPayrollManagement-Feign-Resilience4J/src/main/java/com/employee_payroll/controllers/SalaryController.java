package com.employee_payroll.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.employee_payroll.services.SalaryServiceProxy;
import com.employee_payroll.DTO.SalaryDTO;
import com.employee_payroll.entities.Employee;
import com.employee_payroll.entities.Salary;
import java.util.List;

@RestController

public class SalaryController {

    @Autowired
    SalaryServiceProxy salaryServiceProxy;
    private Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/get-salary/all")
    public List<SalaryDTO> getAllSalary() {
    	log.debug("In getAllSalary");
		List<SalaryDTO> salary = salaryServiceProxy.getAllSalary();
		log.debug("In getAllSalary with return value salary: " + salary);
		return salary;
    }

    @GetMapping("/get-salary/{salaryId}")
    public List<SalaryDTO> getById(@PathVariable int salaryId) {
    	log.debug("In getById with id " + salaryId);
		List<SalaryDTO> salary = salaryServiceProxy.getById(salaryId);
		log.debug("In getById with return value Todo: " + salary);
		return salary;
    }

    @GetMapping("/salary/employee/{employee_id}")
    public List<SalaryDTO> getByEmployeeId(@PathVariable int employee_id) {
    	log.debug("In getAllEmployeeId with employee id" + employee_id);
		List<SalaryDTO> salary = salaryServiceProxy.getByEmployeeId(employee_id);
		log.debug("In getAllEmployee with return value Todo: " + salary);
		return salary;
    }

    @PutMapping("/salary/{salaryId}")
    public void insertByInd(@PathVariable int salaryId, @RequestBody Salary salary) {
        salaryServiceProxy.insertByInd(salaryId, salary);
    }

    @PostMapping("/salary")
    public void updateSalary(@RequestBody Salary salary) {
        salaryServiceProxy.updateSalary(salary);
    }

    @DeleteMapping("/salary/{salaryId}")
    public void deleteByIdSalary(@PathVariable int salaryId) {
        salaryServiceProxy.deleteByIdSalary(salaryId);
    }
}
