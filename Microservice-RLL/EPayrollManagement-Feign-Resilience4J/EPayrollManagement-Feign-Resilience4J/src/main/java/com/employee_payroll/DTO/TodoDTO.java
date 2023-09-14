package com.employee_payroll.DTO;

import java.time.LocalDate;

public class TodoDTO {

	private int id;
	private LocalDate date_assigned;
	private String is_work_assigned;
	private String work_description;
	private int employee_id;

	public TodoDTO(int id, LocalDate date_assigned, String is_work_assigned, String work_description, int employee_id) {
		super();
		this.id = id;
		this.date_assigned = date_assigned;
		this.is_work_assigned = is_work_assigned;
		this.work_description = work_description;
		this.employee_id = employee_id;
	}

	public TodoDTO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate_assigned() {
		return date_assigned;
	}

	public void setDate_assigned(LocalDate date_assigned) {
		this.date_assigned = date_assigned;
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

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int i) {
		this.employee_id = i;
	}

	@Override
	public String toString() {
		return "TodoDTO [id=" + id + ", date_assigned=" + date_assigned + ", is_work_assigned=" + is_work_assigned
				+ ", work_description=" + work_description + ", employee_id=" + employee_id + "]";
	}

}
