package com.practice.test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermissionData pd1 = new PermissionData("View Profiles", "view");
		PermissionData pd2 = new PermissionData("Delete Profiles", "delete");
		
		System.out.println("pd1: " + pd1.getInternalName());
		System.out.println("pd2: " + pd2.getInternalName());

	}

}
