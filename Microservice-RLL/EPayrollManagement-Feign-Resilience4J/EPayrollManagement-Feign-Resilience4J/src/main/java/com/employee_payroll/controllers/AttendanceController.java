package com.employee_payroll.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.employee_payroll.DTO.AttendanceDTO;
import com.employee_payroll.entities.Attendance;
import com.employee_payroll.entities.Employee;
import com.employee_payroll.services.AttendanceServiceProxy;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
public class AttendanceController {

	@Autowired
	private AttendanceServiceProxy attendanceServiceProxy;
	
	private Logger log = LoggerFactory.getLogger(AttendanceController.class);

	@PostMapping("/mark-attendance")
	public ResponseEntity<String> markAttendance(@RequestBody Attendance markAttendance) {
		return attendanceServiceProxy.markAttendance(markAttendance);
	}

	@GetMapping("/get-attendances")
	public List<Attendance> getAllAttendances() {
		log.debug("In getAllAttendances");
		List<Attendance> attendance = attendanceServiceProxy.getAllMarkedAttendances();
		log.debug("In getAllAttendances with return value Todo: " + attendance);
		return attendance;
	}

	@PutMapping("/update-attendance/{id}")
	public ResponseEntity<String> updateAttendance(@PathVariable int id, @RequestBody AttendanceDTO attendanceDetails) {
		Attendance attendance = convertToAttendance(attendanceDetails);
		return attendanceServiceProxy.updateAttendance(id, attendance);
	}

	private Attendance convertToAttendance(AttendanceDTO attendanceDTO) {
		Attendance attendance = new Attendance();
		attendance.setId(attendanceDTO.getId());

		return attendance;
	}

	@DeleteMapping("/delete-attendance/{id}")
	public ResponseEntity<String> deleteAttendance(@PathVariable int id) {
		return attendanceServiceProxy.deleteAttendance(id);
	}
}