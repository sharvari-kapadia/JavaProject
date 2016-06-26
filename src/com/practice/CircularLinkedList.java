package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SKapadia on 6/21/2016.
 */
public class CircularLinkedList {

    private class Node {

        int data;
        Node next;
        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node getHead() {
        return head;
    }

    public void add(int data) {

        Node node = new Node(data);
        if(head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        tail = node;
    }

    private Node getCollision() {

        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null) {
            slow = slow.next;
            if(fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if(slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public boolean isCircular() {
        return getCollision() != null;
    }

    public Node getIntersection() {

        Node slow = head;
        Node fast = getCollision();

        while(slow != null && fast != null) {
            if(slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return null;
    }

    public void createNonCircularLinkedList(ArrayList<Integer> dataList) {

        dataList.forEach(this::add);
    }

    public void createCircularLinkedList(ArrayList<Integer> dataList, int intersectionIndex) {

        createNonCircularLinkedList(dataList);

        //connect last node to kth (intersectionIndex) node
        Node current = head;
        for(int i = 0; i < intersectionIndex; i++) {
            current = current.next;
        }
        tail.next = current;
    }

    public void printLinkedList() {

        Node current = head;
        while(current != null) {

            System.out.print(current.data);
            if(current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public void printLinkedList(int intersectionIndex) {

        Node current = head;
        int i = 0;
        while(current != null) {

            System.out.print(current.data);
            if(i == intersectionIndex) {
                System.out.print(("*"));
            }
            if(current != tail) {
                System.out.print(" -> ");
            } else {
                break;
            }
            current = current.next;
            i++;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ArrayList<Integer> dataList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        // Non-circular linked list
        CircularLinkedList nonCircularLinkedList = new CircularLinkedList();
        nonCircularLinkedList.createNonCircularLinkedList(dataList);
        nonCircularLinkedList.printLinkedList();
        boolean isCircular1 = nonCircularLinkedList.isCircular();
        assert isCircular1 == false;

        // Circular linked list
        for(int i = 0; i < dataList.size(); i++) {
            CircularLinkedList circularLinkedList = new CircularLinkedList();
            circularLinkedList.createCircularLinkedList(dataList, i);
            circularLinkedList.printLinkedList(i);
            boolean isCircular2 = circularLinkedList.isCircular();
            assert isCircular2 == true;
            if(isCircular2) {
                assert circularLinkedList.getIntersection().data == dataList.get(i);
            }
        }
    }
}
