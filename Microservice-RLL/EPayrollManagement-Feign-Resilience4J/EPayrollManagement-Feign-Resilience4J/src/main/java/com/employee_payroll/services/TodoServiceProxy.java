package com.employee_payroll.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.employee_payroll.DTO.TodoDTO;
import com.employee_payroll.entities.Todo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "todo-service")
public interface TodoServiceProxy {

	@Retry(name = "todo-service")
	@CircuitBreaker(name = "todo-service", fallbackMethod = "fallbackMethodScheduleWork")
	@PostMapping("/todos")
	public ResponseEntity<String> scheduleWork(@RequestBody Todo scheduleWork);

	@Retry(name = "todo-service")
	@CircuitBreaker(name = "todo-service", fallbackMethod = "fallbackMethodDeleteWork")
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<String> deleteWork(@PathVariable int id);

	@Retry(name = "todo-service")
	@CircuitBreaker(name = "todo-service", fallbackMethod = "fallbackMethodUpdateWork")
	@PutMapping("/todos/{id}")
	public ResponseEntity<String> updateWork(@PathVariable int id, @RequestBody Todo UpdatedScheduleWork);

	@Retry(name = "todo-service")
	@CircuitBreaker(name = "todo-service", fallbackMethod = "fallbackMethodGetScheduled")
	@GetMapping("/todos/scheduledWorks")
	public List<TodoDTO> getScheduled();

	@Retry(name = "todo-service")
	@CircuitBreaker(name = "todo-service", fallbackMethod = "fallbackMethodGetScheduleWorksForEmployee")
	@GetMapping("/todos/employee/{id}")
	public List<TodoDTO> getScheduleWorksForEmployee(@PathVariable int id);

	default ResponseEntity<String> fallbackMethodScheduleWork(Todo scheduleWork, Throwable cause) {
		System.out.println("Exception raised with the message: " + cause.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallback: Unable to schedule work");
	}

	default ResponseEntity<String> fallbackMethodDeleteWork(int id, Throwable cause) {
		System.out.println("Exception raised with the message: " + cause.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallback: Unable to delete work");
	}

	default ResponseEntity<String> fallbackMethodUpdateWork(int id, Todo UpdatedScheduleWork, Throwable cause) {
		System.out.println("Exception raised with the message: " + cause.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallback: Unable to update work");
	}

	default List<TodoDTO> fallbackMethodGetScheduled(Throwable cause) {
		System.out.println("Exception raised with the message: " + cause.getMessage());
		List<TodoDTO> dummyTodoDTOList = new ArrayList<>();
		TodoDTO dummyTodoDTO = new TodoDTO();
		dummyTodoDTO.setId(1);
		dummyTodoDTO.setDate_assigned(LocalDate.now());
		dummyTodoDTO.setIs_work_assigned("Assigned");
		dummyTodoDTO.setWork_description("description(Fallback)");
		dummyTodoDTO.setEmployee_id(0);
		dummyTodoDTOList.add(dummyTodoDTO);
		return dummyTodoDTOList;
	}

	default List<TodoDTO> fallbackMethodGetScheduleWorksForEmployee(int id, Throwable cause) {
		System.out.println("Exception raised with the message: " + cause.getMessage());
		List<TodoDTO> dummyTodoDTOList = new ArrayList<>();
		TodoDTO dummyTodoDTO = new TodoDTO();
		dummyTodoDTO.setId(id);
		dummyTodoDTO.setDate_assigned(LocalDate.now());
		dummyTodoDTO.setIs_work_assigned("Assigned");
		dummyTodoDTO.setWork_description("description(Fallback)");
		dummyTodoDTO.setEmployee_id(0);
		dummyTodoDTOList.add(dummyTodoDTO);
		return dummyTodoDTOList;
	}
}
