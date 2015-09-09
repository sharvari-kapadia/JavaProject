package com.practice.ctci.tools;

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
    public void removeLast(T data) {
    }

    // Remove first
    public void removeFirst(T data) {
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

    // Print the given myLinkedList
    public static void print(MyLinkedList myLinkedList) {
        MyLinkedList.Node current = myLinkedList.head;
        while(current != null) {
            System.out.print(current.data);
            if(current != myLinkedList.tail) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.remove(myLinkedList.tail);
        myLinkedList.addLast(2);
        print(myLinkedList);
    }
}
