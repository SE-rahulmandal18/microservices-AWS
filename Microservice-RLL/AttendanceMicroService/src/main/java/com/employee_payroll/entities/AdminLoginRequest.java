package com.employee_payroll.entities;

public class AdminLoginRequest {
	private String username;
	private String password;

	// Constructors, getters, and setters (You can generate these using your IDE)

	// Example constructor:
	public AdminLoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public AdminLoginRequest() {

		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Override toString() to handle null values gracefully
	@Override
	public String toString() {
		return "LoginRequest [username=" + (username != null ? username : "null") + ", password=" + password + "]";
	}

}