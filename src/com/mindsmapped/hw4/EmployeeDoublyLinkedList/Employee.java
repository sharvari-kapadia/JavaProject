package com.mindsmapped.hw4.EmployeeDoublyLinkedList;

public class Employee {

    private int employeeId;
    private String employeeName;

    @SuppressWarnings("unused")
    private Employee() {
    }

    public static Employee invalidEmployee() {
        return new Employee(-1, "");
    }

    Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void print() {
        System.out.println(employeeId + ":" + employeeName);
    }
}
