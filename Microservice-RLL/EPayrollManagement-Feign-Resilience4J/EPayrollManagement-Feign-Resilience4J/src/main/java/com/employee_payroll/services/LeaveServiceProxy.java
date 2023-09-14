package com.employee_payroll.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.employee_payroll.DTO.LeavesDTO;
import com.employee_payroll.entities.Leaves;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "leave-service")
public interface LeaveServiceProxy {

	@Retry(name = "leave-service")
	@CircuitBreaker(name = "leave-service", fallbackMethod = "fallbackMethodGetLeaves")
	@GetMapping("/leaves/{id}")
	public ResponseEntity<?> getLeaves(@PathVariable int id);

	@Retry(name = "leaves-service")
	@CircuitBreaker(name = "leave-service", fallbackMethod = "fallbackMethodGetAllLeaves")
	@GetMapping("/leaves/all")
	public List<LeavesDTO> getAllLeaves();

	@Retry(name = "leave-service")
	@CircuitBreaker(name = "leave-service", fallbackMethod = "fallbackMethodApplyLeave")
	@PostMapping("/leaves/apply")
	public ResponseEntity<String> applyLeave(@RequestBody Leaves leave);

	@Retry(name = "leave-service")
	@CircuitBreaker(name = "leave-service", fallbackMethod = "fallbackMethodUpdateLeave")
	@PutMapping("/leaves/update/{id}")
	public void updateLeave(@PathVariable int id, @RequestBody Leaves leave);

	@Retry(name = "leave-service")
	@CircuitBreaker(name = "leave-service", fallbackMethod = "fallbackMethodDeleteLeave")
	@DeleteMapping("/leaves/delete/{id}")
	public void deleteLeave(@PathVariable int id);

	default ResponseEntity<?> fallbackMethodGetLeaves(int id, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		// Create and return dummy data for a single leave
		LeavesDTO dummyLeaveDTO = new LeavesDTO();
		dummyLeaveDTO.setId(0);
		dummyLeaveDTO.setLeaveType(" fallbackMethodGetLeaves Sick Leave");
		dummyLeaveDTO.setStartDate(LocalDate.parse("2023-09-10"));
		dummyLeaveDTO.setEndDate(LocalDate.parse("2023-09-12"));
		dummyLeaveDTO.setReason("Medical condition");
		dummyLeaveDTO.setEmployee_id(1);
		return ResponseEntity.ok(dummyLeaveDTO);
	}

	default List<LeavesDTO> fallbackMethodGetAllLeaves(Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		List<LeavesDTO> dummyLeaveDTOList = new ArrayList<>();
		LeavesDTO dummyLeaveDTO1 = new LeavesDTO();
		dummyLeaveDTO1.setId(0);
		dummyLeaveDTO1.setLeaveType("fallbackMethodGetAllLeaves Sick Leave");
		dummyLeaveDTO1.setStartDate(LocalDate.parse("2023-09-10"));
		dummyLeaveDTO1.setEndDate(LocalDate.parse("2023-09-12"));
		dummyLeaveDTO1.setReason("Medical condition");
		dummyLeaveDTO1.setEmployee_id(1);
		dummyLeaveDTOList.add(dummyLeaveDTO1);
		return dummyLeaveDTOList;
	}

	default ResponseEntity<String> fallbackMethodApplyLeave(Leaves leave, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Leave application failed");
	}

	default void fallbackMethodUpdateLeave(int id, Leaves leave, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
	}

	default void fallbackMethodDeleteLeave(int id, Throwable cause) {
		System.out.println("Exception raised with message: ====>" + cause.getMessage());
	}
}
