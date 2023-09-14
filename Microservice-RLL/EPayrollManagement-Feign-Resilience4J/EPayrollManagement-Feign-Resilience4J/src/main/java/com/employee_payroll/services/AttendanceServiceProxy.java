package com.employee_payroll.services;

import java.time.LocalDate;
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
import com.employee_payroll.entities.Attendance;
import com.employee_payroll.entities.Employee;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "attendance-service")
public interface AttendanceServiceProxy {

	@Retry(name = "attendance-service")
	@CircuitBreaker(name = "attendance-service", fallbackMethod = "fallbackMethodMarkAttendance")
	@PostMapping("/attendance/mark")
	ResponseEntity<String> markAttendance(@RequestBody Attendance markAttendance);

	@Retry(name = "attendance-service")
	@CircuitBreaker(name = "attendance-service", fallbackMethod = "fallbackMethodGetAllMarkedAttendances")
	@GetMapping("/attendance/all")
	List<Attendance> getAllMarkedAttendances();

	@Retry(name = "attendance-service")
	@CircuitBreaker(name = "attendance-service", fallbackMethod = "fallbackMethodUpdateAttendance")
	@PutMapping("/attendance/update/{id}")
	ResponseEntity<String> updateAttendance(@PathVariable int id, @RequestBody Attendance updateAttendance);

	@Retry(name = "attendance-service")
	@CircuitBreaker(name = "attendance-service", fallbackMethod = "fallbackMethodDeleteAttendance")
	@DeleteMapping("/attendance/delete/{id}")
	ResponseEntity<String> deleteAttendance(@PathVariable int id);

	default ResponseEntity<String> fallbackMethodMarkAttendance(Attendance markAttendance, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Attendance marking failed");
	}

	default List<Attendance> fallbackMethodGetAllMarkedAttendances(Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		List<Attendance> dummyDataList = new ArrayList<>();
		Attendance dummyAttendance1 = new Attendance();
		dummyAttendance1.setId(0);
		dummyAttendance1.setCheck_in("09:00 AM");
		dummyAttendance1.setCheck_out("05:00 PM");
		dummyAttendance1.setDate(LocalDate.parse("2023-09-09"));
		dummyAttendance1.setStatus("Present");
		dummyDataList.add(dummyAttendance1);
		return dummyDataList;
//		return new ArrayList<>();
	}

	default ResponseEntity<String> fallbackMethodUpdateAttendance(int id, Attendance updateAttendance,
			Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update failed");
	}

	default ResponseEntity<String> fallbackMethodDeleteAttendance(int id, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete failed");
	}
}