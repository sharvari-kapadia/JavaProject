package com.mindsmapped.hw4.PositiveIntegerDoublyLinkedList;

public class DoublyList {
	public Node head;
	public Node tail;
	public int size;
	
	DoublyList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void pushFront (int item) {
		Node node = new Node();
		node.data = item;
		node.prev = null;
		
		if(size == 0) {
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
	
	public void pushBack (int item) {
		Node node = new Node();
		node.data = item;
		node.next = null;
		
		if(size == 0) {
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
	
	public int popFront () {
		int value; 
		
		if(size > 1) {
			value = head.data;
			
			Node node = head.next;
			node.prev = null;
			head.next = null;
			head = node;
			
		} else if(size == 1) {
			value = head.data;
			
			head = null;
			tail = null;
		} else {
			value = -1;
		}
		
		size--;
		return value;
	}
	
	public int popBack () {
		int value;
		
		if(size > 1) {
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
			value = -1;
		}
		
		size--;
		return value;
	}
	
	public int front() {
		return head.data;
	}
	
	public int back() {
		return tail.data;
	}
	
	public void print () {
		if (size == 0) {
			System.out.println("List is empty!");
			return;
		}
		Node node = head;
		while(node != null) {
			if(node != head) {
				System.out.print(" <-> " + node.data);
			} else {
				System.out.print(node.data);
			}
			
			node = node.next;
		}
		System.out.println();
	}
	
	public boolean search (int item) {
		Node node = head;
		while(node != null) {
			if(node.data == item) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
}
