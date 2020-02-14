package com.example.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4496474307908742778L;
	@JsonProperty("data")
	private Employee[] employees;
	@JsonProperty("status")
	private String status;

	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
