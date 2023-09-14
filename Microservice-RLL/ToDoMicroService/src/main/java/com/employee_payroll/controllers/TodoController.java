package com.employee_payroll.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.employee_payroll.DTO.TodoDTO;
import com.employee_payroll.Exceptions.CustomException;
import com.employee_payroll.entities.Employee;
import com.employee_payroll.entities.Todo;
import com.employee_payroll.repositories.EmployeeRepo;
import com.employee_payroll.repositories.TodoRepo;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*")
public class TodoController {

	@Autowired
	private TodoRepo scheduleWorkRepo;

	@Autowired
	private EmployeeRepo employeeRepo;

	@PostMapping
	public ResponseEntity<String> scheduleWork(@RequestBody Todo scheduleWork) {
		Optional<Employee> employee = employeeRepo.findById(scheduleWork.getEmployee().getId());
		if (employee.isPresent()) {
			scheduleWork.setEmployee(employee.get());
			scheduleWorkRepo.save(scheduleWork);
			return ResponseEntity.status(HttpStatus.CREATED).body("Work schedule assigned successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee not found, work schedule not assigned");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteWork(@PathVariable int id) {
		Optional<Todo> scheduleWork = scheduleWorkRepo.findById(id);
		if (scheduleWork.isPresent()) {
			scheduleWorkRepo.deleteById(id);
			return ResponseEntity.ok("Work schedule deleted successfully");
		} else {
			throw new CustomException("Scheduled work id not found");
		}
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateWork(@PathVariable int id, @RequestBody Todo UpdatedScheduleWork) {
		Todo existingWork = scheduleWorkRepo.findById(id).orElse(null);
		if (existingWork != null) {
			existingWork.setDate_assigned(UpdatedScheduleWork.getDate_assigned());
			existingWork.setIs_work_assigned(UpdatedScheduleWork.getIs_work_assigned());
			existingWork.setWork_description(UpdatedScheduleWork.getWork_description());

			scheduleWorkRepo.save(existingWork);

			return ResponseEntity.ok("Work schedule updated successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Work schedule not found");
		}
	}

	@GetMapping("/scheduledWorks")
	public List<TodoDTO> getScheduled() {
		List<Todo> scheduleWorks = scheduleWorkRepo.findAll();
		List<TodoDTO> scheduleWorkDTOs = new ArrayList<>();
		for (Todo scheduleWork : scheduleWorks) {
			TodoDTO dto = new TodoDTO();
			dto.setId(scheduleWork.getId());
			dto.setDate_assigned(scheduleWork.getDate_assigned());
			dto.setIs_work_assigned(scheduleWork.getIs_work_assigned());
			dto.setWork_description(scheduleWork.getWork_description());
			dto.setEmployee_id(scheduleWork.getEmployee().getId());
			scheduleWorkDTOs.add(dto);
		}

		return scheduleWorkDTOs;
	}

	@GetMapping("/employee/{id}")
	public List<TodoDTO> getScheduleWorksForEmployee(@PathVariable int id) {
		List<Todo> scheduleWorks = scheduleWorkRepo.findAllByEmployeeId(id);
		List<TodoDTO> scheduleWorkDTOs = new ArrayList<>();
		for (Todo scheduleWork : scheduleWorks) {
			TodoDTO dto = new TodoDTO();
			dto.setId(scheduleWork.getId());
			dto.setDate_assigned(scheduleWork.getDate_assigned());
			dto.setIs_work_assigned(scheduleWork.getIs_work_assigned());
			dto.setWork_description(scheduleWork.getWork_description());
			dto.setEmployee_id(scheduleWork.getEmployee().getId());
			scheduleWorkDTOs.add(dto);
		}

		return scheduleWorkDTOs;
	}
}
