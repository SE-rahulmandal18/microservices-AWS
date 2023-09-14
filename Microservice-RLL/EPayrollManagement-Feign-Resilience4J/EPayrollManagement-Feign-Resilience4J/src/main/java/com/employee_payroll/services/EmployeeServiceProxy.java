package com.employee_payroll.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee_payroll.DTO.EmployeeDTO;
import com.employee_payroll.entities.Employee;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "employee-service")
public interface EmployeeServiceProxy {

	@Retry(name = "employee-service")
	@CircuitBreaker(name = "employee-service", fallbackMethod = "fallbackMethodGetEmployee")
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id);

	@Retry(name = "employee-service")
	@CircuitBreaker(name = "employee-service", fallbackMethod = "fallbackMethodGetAllEmployees")
	@GetMapping("/employees")
	public List<Employee> getAllEmployees();

	@Retry(name = "employee-service")
	@CircuitBreaker(name = "employee-service", fallbackMethod = "fallbackMethodCreateEmployee")
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee);

	@Retry(name = "employee-service")
	@CircuitBreaker(name = "employee-service", fallbackMethod = "fallbackMethodUpdateEmployee")
	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDetails);

	@Retry(name = "employee-service")
	@CircuitBreaker(name = "employee-service", fallbackMethod = "fallbackMethodDeleteEmployee")
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id);

	default ResponseEntity<?> fallbackMethodGetEmployee(int id, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		Employee dummyEmployee = new Employee("Fallback", "fallback@example.com", "Developer", "IT", "Male");
		EmployeeDTO dummyEmployeeDTO = new EmployeeDTO();
		dummyEmployeeDTO.setId(0  );
		dummyEmployeeDTO.setName(dummyEmployee.getName());
		dummyEmployeeDTO.setMail_id(dummyEmployee.getMail_id());
		dummyEmployeeDTO.setRole(dummyEmployee.getRole()); 
		dummyEmployeeDTO.setCategory(dummyEmployee.getCategory());
		dummyEmployeeDTO.setGender(dummyEmployee.getGender());
		return ResponseEntity.ok(dummyEmployeeDTO);
	}

	default List<Employee> fallbackMethodGetAllEmployees(Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		List<Employee> dummyDataList = new ArrayList<>();
		Employee dummyEmployee = new Employee("Rahul Fallback", "rahulFallback@example.com", "Developer", "IT", "Male");
		dummyDataList.add(dummyEmployee);
		return dummyDataList;
//      return new ArrayList<>();
	}

	default ResponseEntity<Employee> fallbackMethodCreateEmployee(Employee employee, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		Employee dummyEmployee = new Employee("Rahul Fallback", "rahulFallback@example.com", "Developer", "IT", "Male");
		return ResponseEntity.ok(dummyEmployee);
	}

	default ResponseEntity<String> fallbackMethodUpdateEmployee(int id, EmployeeDTO employeeDetails, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update failed");
	}

	default ResponseEntity<String> fallbackMethodDeleteEmployee(int id, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete failed");
	}
}
