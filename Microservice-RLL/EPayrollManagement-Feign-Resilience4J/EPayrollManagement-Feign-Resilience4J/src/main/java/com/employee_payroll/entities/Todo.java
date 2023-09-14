package com.employee_payroll.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors
public class Todo {

	private int id;

	private String is_work_assigned;

	private String work_description;

	private LocalDate date_assigned;

	private Employee employee;

	public Todo() {
		super();
	}

	public Todo(String is_work_assigned, String work_description, LocalDate dateAdded, Employee employee) {
		super();
		this.is_work_assigned = is_work_assigned;
		this.work_description = work_description;
		this.date_assigned = dateAdded;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public String getIs_work_assigned() {
		return is_work_assigned;
	}

	public void setIs_work_assigned(String is_work_assigned) {
		this.is_work_assigned = is_work_assigned;
	}

	public String getWork_description() {
		return work_description;
	}

	public void setWork_description(String work_description) {
		this.work_description = work_description;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDate getDate_assigned() {
		return date_assigned;
	}

	public void setDate_assigned(LocalDate dateAdded) {
		this.date_assigned = dateAdded;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", is_work_assigned=" + is_work_assigned + ", work_description=" + work_description
				+ ", date_assigned=" + date_assigned + ", employee=" + employee + "]";
	}
	

}
