/* 
 * 4.28.2015: HW2
 * 	
 * Create Employee class as parent class
 * 		- members variables: name, id, phone, address
 * 		- methods: dailyTask, statusReport
 * 
 * Create child classes: TempEmployee & PermEmployee that extends parent class Employee
 * 	1. TempEmployee class 
 * 		- member variables: vendorName, vendorId
 * 		- methods: calculateContractPeriod
 * 	2. PermEmployee class
 * 		- member variables: employeeNumber, deptName
 * 		- methods: getManagerName
 * 	
 * main method: 
 * 		- Create object of all three classes
 * 		- Call its methods
 */

package com.mindsmapped.hw2;

public class Employee {
	private String name;
	private int id;
	private int phone;
	private String address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void dailyTask() {
		System.out.println("In method dailyTask of Employee class.");
	}
	
	public void statusReport() {
		System.out.println("In method statusReport of Employee class.");
	}
	
	public static void main(String args[]) {
		Employee e = new Employee();
		e.dailyTask();
		e.statusReport();
		
		TempEmployee te = new TempEmployee();
		te.calculateContractPeriod();
		
		PermEmployee pe = new PermEmployee();
		pe.getManagerName();
	}
}



