package com.mindsmapped.hw4.EmployeeDoublyLinkedList;

import java.util.ArrayList;


public class Node {
	public Employee data;
	public Node next;
	public Node prev;
	
	public static void main (String args[]) {
		DoublyList l = new DoublyList();
		
		l.pushBack(new Employee(1, "Sharvari"));
		l.pushBack(new Employee(2, "Aakash"));
		l.pushBack(new Employee(3, "Monica"));
		l.pushBack(new Employee(4, "Chandler"));
		l.pushBack(new Employee(5, "Sharvari"));
		l.pushBack(new Employee(6, "Aakash"));
		
		l.print();
		
		ArrayList<Employee> searchResult1 = l.search("Sharvari");
		for(Employee e : searchResult1) {
			e.print();
		}
		
		Employee searchResult2 = l.search(1);
		searchResult2.print();
		
		l.popBack();
		l.popBack();
		
		l.print();
		
		ArrayList<Employee> searchResult3 = l.search("Sharvariii");
		for(Employee e : searchResult3) {
			e.print();
		}
	}
}
