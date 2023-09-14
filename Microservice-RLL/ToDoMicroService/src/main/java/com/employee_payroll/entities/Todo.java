package com.employee_payroll.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors
@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String is_work_assigned;

	private String work_description;

	private LocalDate date_assigned;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDate getDate_assigned() {
		return date_assigned;
	}

	public void setDate_assigned(LocalDate date_assigned) {
		this.date_assigned = date_assigned;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Todo(int id, String is_work_assigned, String work_description, LocalDate date_assigned, Employee employee) {
		super();
		this.id = id;
		this.is_work_assigned = is_work_assigned;
		this.work_description = work_description;
		this.date_assigned = date_assigned;
		this.employee = employee;
	}

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", is_work_assigned=" + is_work_assigned + ", work_description=" + work_description
				+ ", date_assigned=" + date_assigned + ", employee=" + employee + "]";
	}

	

}
