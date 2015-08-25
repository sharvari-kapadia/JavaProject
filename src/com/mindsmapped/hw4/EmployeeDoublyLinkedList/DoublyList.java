package com.mindsmapped.hw4.EmployeeDoublyLinkedList;

import java.util.ArrayList;

public class DoublyList {

    public Node head;
    public Node tail;
    public int size;

    DoublyList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void pushFront(Employee item) {

        Node node = new Node();
        node.data = item;
        node.prev = null;

        if (size == 0) {
            node.next = null;
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void pushBack(Employee item) {

        Node node = new Node();
        node.data = item;
        node.next = null;

        if (size == 0) {
            node.prev = null;
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public Employee popFront() {

        Employee value;

        if (size > 1) {
            value = head.data;

            Node node = head.next;
            node.prev = null;
            head.next = null;
            head = node;

        } else if (size == 1) {
            value = head.data;

            head = null;
            tail = null;
        } else {
            value = Employee.invalidEmployee();
        }

        size--;
        return value;
    }

    public Employee popBack() {

        Employee value;

        if (size > 1) {
            value = tail.data;

            Node node = tail.prev;
            node.next = null;
            tail.prev = null;
            tail = node;
        } else if (size == 1) {
            value = tail.data;

            tail = null;
            head = null;
        } else {
            value = Employee.invalidEmployee();
        }

        size--;
        return value;
    }

    public Employee front() {
        return head.data;
    }

    public Employee back() {
        return tail.data;
    }

    public void print() {

        if (size == 0) {
            System.out.println("List is empty!");
            return;
        }
        Node node = head;
        while (node != null) {
            String toPrint = node.data.getEmployeeId() + ":" + node.data.getEmployeeName();
            if (node != head) {
                System.out.print(" <-> " + toPrint);
            } else {
                System.out.print(toPrint);
            }

            node = node.next;
        }
        System.out.println();
    }

    public Employee search(int employeeId) {

        Node node = head;
        while (node != null) {
            if (node.data.getEmployeeId() == employeeId) {
                return node.data;
            }
            node = node.next;
        }
        return Employee.invalidEmployee();
    }

    public ArrayList<Employee> search(String employeeName) {

        ArrayList<Employee> employeeArray = new ArrayList<Employee>();
        Node node = head;
        while (node != null) {
            if (node.data.getEmployeeName().equals(employeeName)) {
                employeeArray.add(node.data);
            }
            node = node.next;
        }
        return employeeArray;
    }
}
