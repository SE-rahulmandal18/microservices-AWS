package com.employee_payroll.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employee_payroll.DTO.TodoDTO;
import com.employee_payroll.entities.Todo;
import com.employee_payroll.services.TodoServiceProxy;

@RestController
public class TodoController {

	@Autowired
	private TodoServiceProxy todoServiceProxy;
	private Logger log = LoggerFactory.getLogger(TodoController.class);

	@PostMapping("/post-todos")
	public ResponseEntity<String> scheduleWork(@RequestBody Todo scheduleWork) {
		return todoServiceProxy.scheduleWork(scheduleWork);
	}

	@DeleteMapping("/delete-todos/{id}")
	public ResponseEntity<String> deleteWork(@PathVariable int id) {
		return todoServiceProxy.deleteWork(id);
	}

	@PutMapping("/put-todos/{id}")
	public ResponseEntity<String> updateWork(@PathVariable int id, @RequestBody Todo UpdatedScheduleWork) {
		return todoServiceProxy.updateWork(id, UpdatedScheduleWork);
	}

	@GetMapping("/get-todos/scheduledWorks")
	public List<TodoDTO> getScheduled() {
		log.debug("In getScheduleWorksForAll");
		List<TodoDTO> todo = todoServiceProxy.getScheduled();
		log.debug("In getScheduleWorks with return value Todo: " + todo);
		return todo;
	}

	@GetMapping("/get-todos/employee/{id}")
	public List<TodoDTO> getScheduleWorksForEmployee(@PathVariable int id) {
		log.debug("In getScheduleWorksForEmployee with id: " + id);
		List<TodoDTO> todo = todoServiceProxy.getScheduleWorksForEmployee(id);
		log.debug("In getScheduleWorksForEmployee with return value Todo: " + todo);
		return todo;
	}
}