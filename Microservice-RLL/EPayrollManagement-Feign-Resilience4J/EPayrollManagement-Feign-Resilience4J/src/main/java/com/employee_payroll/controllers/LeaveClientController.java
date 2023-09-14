package com.employee_payroll.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.employee_payroll.DTO.LeavesDTO;
import com.employee_payroll.entities.Employee;
import com.employee_payroll.entities.Leaves;
import com.employee_payroll.services.LeaveServiceProxy;

import java.util.List;

@RestController

public class LeaveClientController {

	@Autowired
	private LeaveServiceProxy leaveServiceProxy;
	private Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping("/get-leave/{id}")
	public ResponseEntity<?> getLeaves(@PathVariable int id) {
		log.debug("In getLeaves");
		ResponseEntity<?> leave = leaveServiceProxy.getLeaves(id);
		log.debug("In getLeaves with return value leave: " + leave);
		return leave;
	}

	@GetMapping("/get-leaves")
	public List<LeavesDTO> getAllLeaves() {
		log.debug("In getAllLeaves");
		List<LeavesDTO> leave = leaveServiceProxy.getAllLeaves();
		log.debug("In getAllleaves with return value leave: " + leave);
		return leave;
	}

	@PostMapping("/post-leave")
	public ResponseEntity<String> applyLeave(@RequestBody Leaves leave) {
		return leaveServiceProxy.applyLeave(leave);
	}

	@PutMapping("/put-leave/{id}")
	public void updateLeave(@PathVariable int id, @RequestBody Leaves leave) {
		leaveServiceProxy.updateLeave(id, leave);
	}

	@DeleteMapping("/delete-leave/{id}")
	public void deleteLeave(@PathVariable int id) {
		leaveServiceProxy.deleteLeave(id);
	}
}
