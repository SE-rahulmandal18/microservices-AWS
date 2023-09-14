package com.employee_payroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
public class Employee {

	private int id;

	private String name;

	private String mail_id;

	private String role;

	private String category;

	private String gender;

	public Employee() {
		super();
	}

	public Employee(String name, String mail_id, String role, String category, String gender) {
		super();
		this.name = name;
		this.mail_id = mail_id;
		this.role = role;
		this.category = category;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail_id() {
		return mail_id;
	}

	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", mail_id=" + mail_id + ", role=" + role + ", category="
				+ category + ", gender=" + gender + "]";
	}

}
