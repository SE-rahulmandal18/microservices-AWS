package com.employee_payroll.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_payroll.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmployeeId(int employeeId);
	
}
