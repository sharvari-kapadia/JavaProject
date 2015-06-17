package com.mindsmapped.hw2;

public class TempEmployee extends Employee {
	private String vendorName;
	private int vendorId;
	
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	
	public void calculateContractPeriod() {
		System.out.println("In method calculateContractPeriod of TempEmployee class.");
	}
}
