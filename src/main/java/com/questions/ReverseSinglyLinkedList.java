package com.questions;

/**
 * Created by SKapadia on 4/25/2016.
 */
public class ReverseSinglyLinkedList {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    ReverseSinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addLast(int data) {

        Node node = new Node(data);
        if(size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public void reverse() {

        Node current = head;
        Node oldTail = tail;
        boolean firstTime = true;

        for(int i = 0; i < size - 1; i++) {

            head = current.next;
            current.next = oldTail.next;
            oldTail.next = current;
            if(firstTime) {
                tail = current;
                firstTime = false;
            }
            current = head;
        }
    }

    public void printLinkedList() {

        Node current = head;
        System.out.println();
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {

        ReverseSinglyLinkedList ll = new ReverseSinglyLinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.printLinkedList();
        ll.reverse();
        ll.printLinkedList();
    }
}
