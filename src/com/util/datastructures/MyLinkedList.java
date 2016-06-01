package com.util.datastructures;

import java.security.InvalidParameterException;

/**
 * Created by SKapadia on 9/8/2015.
 */
public class MyLinkedList <T> {

    public class Node {
        public T data;
        public Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Add last
    public void addLast(T data) {
        if(data == null) {
            return;
        }

        Node node = new Node();
        node.data = data;

        if(getSize() == 0) {
            node.next = null;
            head = node;
            tail = node;
        } else {
            node.next = null;
            tail.next = node;
            tail = node;
        }

        setSize(getSize() + 1);
    }

    // Add first
    public void addFirst(T data) {
    }

    // Remove last
    public void removeLast() {

    }

    // Remove first
    public void removeFirst() {

        if(getSize() == 0) {
            return;
        }

        if(getSize() == 1) {
            head = null;
            tail = null;
        } else {
            Node temp = head;
            head = head.next;
            temp.next = null;
        }

        setSize(getSize() - 1);
    }

    // Remove given node
    public void remove(Node node) throws Exception {
        if(node == null) {
            throw new InvalidParameterException();
        }

        if(getSize() == 0) {
            throw new Exception("Empty Linked List");
        }

        if(size == 1) {
            head = null;
            tail = null;
            node.next = null;
        } else {
            if(node == head) {
                head = head.next;
                node.next = null;
            } else {
                Node current = head;
                while(current.next != null) {
                    if(current.next == node) {
                        current.next = node.next;
                        node.next = null;
                        if(node == tail) {
                            tail = current;
                        }
                        break;
                    }
                    current = current.next;
                }
            }
        }

        setSize(getSize() - 1);
    }

    public void reset() {
        head = null;
        tail = null;
        setSize(0);
    }

    public void append(MyLinkedList otherLinkedList) {

        if(otherLinkedList.getSize() == 0) {
            return;
        }

        if(getSize() == 0) {
            head = otherLinkedList.getHead();
            tail = otherLinkedList.getTail();
        } else {
            tail.next = otherLinkedList.getHead();
            tail = otherLinkedList.getTail();
        }
        setSize(getSize() + otherLinkedList.getSize());
        otherLinkedList.reset();
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        myLinkedList.addLast(6);
        LinkedListUtil.printMyLinkedList(myLinkedList);

        MyLinkedList<Integer> myLinkedList1 = new MyLinkedList<Integer>();
        myLinkedList1.addLast(11);
        myLinkedList1.addLast(21);
        myLinkedList1.addLast(31);
        myLinkedList1.addLast(41);
        myLinkedList1.addLast(51);
        LinkedListUtil.printMyLinkedList(myLinkedList1);

        myLinkedList.append(myLinkedList1);
        LinkedListUtil.printMyLinkedList(myLinkedList);
    }
}
