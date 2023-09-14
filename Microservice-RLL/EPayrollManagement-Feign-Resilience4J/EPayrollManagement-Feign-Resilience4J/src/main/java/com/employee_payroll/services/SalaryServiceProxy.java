package com.employee_payroll.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.employee_payroll.DTO.SalaryDTO;
import com.employee_payroll.entities.Salary;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "salary-service")
public interface SalaryServiceProxy {
	@Retry(name = "salary-service")
	@CircuitBreaker(name = "salary-service", fallbackMethod = "fallbackMethodGetAllSalary")
	@GetMapping("/salary/all")
	public List<SalaryDTO> getAllSalary();

	@Retry(name = "salary-service")
	@CircuitBreaker(name = "salary-service", fallbackMethod = "fallbackMethodGetById")
	@GetMapping("/salary/{salaryId}")
	public List<SalaryDTO> getById(@PathVariable int salaryId);

	@Retry(name = "salary-service")
	@CircuitBreaker(name = "salary-service", fallbackMethod = "fallbackMethodGetEmployeeId")
	@GetMapping("/salary/employee/{employee_id}")
	public List<SalaryDTO> getByEmployeeId(@PathVariable int employee_id);

	@Retry(name = "salary-service")
	@CircuitBreaker(name = "salary-service", fallbackMethod = "fallbackMethodInsertByInd")
	@PutMapping("/salary/{salaryId}")
	public void insertByInd(@PathVariable int salaryId, @RequestBody Salary salary);

	@Retry(name = "salary-service")
	@CircuitBreaker(name = "salary-service", fallbackMethod = "fallbackMethodUpdateSalary")
	@PostMapping("/salary")
	public void updateSalary(@RequestBody Salary salary);

	@Retry(name = "salary-service")
	@CircuitBreaker(name = "salary-service", fallbackMethod = "fallbackMethodDeleteByIdSalary")
	@DeleteMapping("/salary/{salaryId}")
	public void deleteByIdSalary(@PathVariable int salaryId);

	default List<SalaryDTO> fallbackMethodGetAllSalary(Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		List<SalaryDTO> dummySalaryDTOList = new ArrayList<>();
		SalaryDTO dummySalaryDTO1 = new SalaryDTO();
		dummySalaryDTO1.setId(1);
		dummySalaryDTO1.setEmployee_id(1);
		dummySalaryDTO1.setAmount("30000");
		dummySalaryDTOList.add(dummySalaryDTO1);
		return dummySalaryDTOList;
	}

	default List<SalaryDTO> fallbackMethodGetById(int salaryId, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		List<SalaryDTO> dummySalaryDTOList = new ArrayList<>();
		SalaryDTO dummySalaryDTO = new SalaryDTO();
		dummySalaryDTO.setId(salaryId);
		dummySalaryDTO.setEmployee_id(1);
		dummySalaryDTO.setAmount("30000.0");
		dummySalaryDTOList.add(dummySalaryDTO);

		return dummySalaryDTOList;
	}

	default List<SalaryDTO> fallbackMethodGetEmployeeId(int employee_id, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		List<SalaryDTO> dummySalaryDTOList = new ArrayList<>();
		SalaryDTO dummySalaryDTO1 = new SalaryDTO();
		dummySalaryDTO1.setId(1);
		dummySalaryDTO1.setEmployee_id(employee_id);
		dummySalaryDTO1.setAmount("30000.0");
		dummySalaryDTOList.add(dummySalaryDTO1);
		return dummySalaryDTOList;
	}

	default void fallbackMethodInsertByInd(int salaryId, Salary salary, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
	}

	default void fallbackMethodUpdateSalary(Salary salary, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
	}

	default void fallbackMethodDeleteByIdSalary(int salaryId, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
	}
}
