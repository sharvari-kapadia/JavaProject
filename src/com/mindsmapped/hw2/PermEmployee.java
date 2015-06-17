package com.mindsmapped.hw2;

public class PermEmployee extends Employee {
	private int employeeNumber;
	private String deptName;
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void getManagerName() {
		System.out.println("In method getManagerName of PermEmployee class.");
	}
}
