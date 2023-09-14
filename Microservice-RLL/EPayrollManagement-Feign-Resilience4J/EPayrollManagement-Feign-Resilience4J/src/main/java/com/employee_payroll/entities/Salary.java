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
public class Salary {

	private int id;

	private LocalDate salary_credited_date;
	private String amount;

	private Employee employee;

	public LocalDate getSalary_credited_date() {
		return salary_credited_date;
	}

	public void setSalary_credited_date(LocalDate salary_credited_date) {
		this.salary_credited_date = salary_credited_date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public Salary(LocalDate salary_credited_date, String amount, Employee employee) {
		super();
		this.salary_credited_date = salary_credited_date;
		this.amount = amount;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Salary [id=" + id + ", salary_credited_date=" + salary_credited_date + ", amount=" + amount
				+ ", employee=" + employee + "]";
	}

	public Salary() {
	}

}
