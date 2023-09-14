package com.employee_payroll.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_payroll.entities.Todo;

public interface TodoRepo extends JpaRepository<Todo, Integer>{

	List<Todo> findAllByEmployeeId(int employeeId);
	
}
