package com.employee_payroll.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee_payroll.DTO.AttendanceDTO;
import com.employee_payroll.entities.Attendance;
import com.employee_payroll.entities.Employee;
import com.employee_payroll.repositories.AttendanceRepository;
import com.employee_payroll.repositories.EmployeeRepo;

@RestController
@RequestMapping("/attendance") // Set the base path for the controller

public class AttendanceController {

	@Autowired
	private AttendanceRepository attendanceRepository;

	@Autowired
	private EmployeeRepo employeeRepository;

	@PostMapping("/mark")
	public ResponseEntity<String> markAttendance(@RequestBody Attendance markAttendance) {

		Optional<Employee> employee = employeeRepository.findById(markAttendance.getEmployee().getId());

		if (employee.isPresent()) {
			markAttendance.setEmployee(employee.get());
			attendanceRepository.save(markAttendance);
			return ResponseEntity.status(HttpStatus.CREATED).body("Attendance Marked ");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee not found ");
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAttendance(@RequestParam("id") int id) {
		Optional<Attendance> deleteAttendance = attendanceRepository.findById(id);

		if (deleteAttendance.isPresent()) {
			attendanceRepository.deleteById(id);
			return ResponseEntity.ok("Attendance deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Attendance not found");
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateAttendance(@PathVariable int id, @RequestBody Attendance updateAttendance) {

		Attendance alreadyMarked = attendanceRepository.findById(id).orElse(null);

		if (alreadyMarked != null) {
			alreadyMarked.setDate(updateAttendance.getDate());
			alreadyMarked.setCheck_in(updateAttendance.getCheck_in());
			alreadyMarked.setCheck_out(updateAttendance.getCheck_out());
			alreadyMarked.setStatus(updateAttendance.getStatus());

			attendanceRepository.save(alreadyMarked);

			return ResponseEntity.ok("Attendance updated successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Attendance not marked yet ");
		}
	}

	@GetMapping("/all")
	public List<AttendanceDTO> getAllMarkedAttendances() {
		List<Attendance> scheduleWorks = attendanceRepository.findAll();
		List<AttendanceDTO> scheduleWorkDTOs = new ArrayList<>();

		for (Attendance scheduleWork : scheduleWorks) {
			AttendanceDTO dto = new AttendanceDTO();
			dto.setId(scheduleWork.getId());
			dto.setDate(scheduleWork.getDate());
			dto.setCheck_in(scheduleWork.getCheck_in());
			dto.setCheck_out(scheduleWork.getCheck_out());
			dto.setStatus(scheduleWork.getStatus());
			dto.setEmployee_id(scheduleWork.getEmployee().getId());
			scheduleWorkDTOs.add(dto);
		}

		return scheduleWorkDTOs;
	}

	@GetMapping("/employee")
	public List<AttendanceDTO> getMarkedAttendancesForEmployee(@RequestParam("id") int employeeId) {
		List<Attendance> attendances = attendanceRepository.findAllByEmployeeId(employeeId);
		List<AttendanceDTO> attendanceDTO = new ArrayList<>();

		for (Attendance attendance : attendances) {
			AttendanceDTO dto = new AttendanceDTO();
			dto.setId(attendance.getId());
			dto.setDate(attendance.getDate());
			dto.setCheck_in(attendance.getCheck_in());
			dto.setCheck_out(attendance.getCheck_out());
			dto.setStatus(attendance.getStatus());
			dto.setEmployee_id(attendance.getEmployee().getId());
			attendanceDTO.add(dto);
		}

		return attendanceDTO;
	}
}
