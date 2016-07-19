package com.practice;

import java.util.ArrayList;

/**
 * Created by SKapadia on 7/18/2016.
 */
public class CircularSinglyLinkedList {

    public class Node {

        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CircularSinglyLinkedList() {

        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private boolean addWhenSizeZero(Node node) {

        if(getSize() == 0) {
            node.next = node;
            head = node;
            tail = node;
            size++;
            return true;
        }
        return false;
    }

    private boolean deleteWhenSizeZeroOrOne() {

        if(getSize() == 0) {
            return true;
        }

        if(getSize() == 1) {
            head = null;
            tail = null;
            size--;
            return true;
        }
        return false;
    }

    private ArrayList<Node> _search(int data) {

        ArrayList<Node> resultList = new ArrayList<>();
        Node current = head;
        do {
            if(current != null) {
                if(current.data == data) {
                    resultList.add(current);
                }
                current = current.next;
            }
        } while(current != head);

        return resultList;
    }

    private void _delete(ArrayList<Node> nodes) {

        if(!nodes.isEmpty()) {

            Node previous = head;
            Node current = null;

            for(Node node: nodes) {
                if(node == head) {
                    deleteFirst();
                    continue;
                }

                if(node == tail) {
                    deleteLast();
                    continue;
                }

                if(previous != null) {
                    current = previous.next;
                }

                while(current != node) {
                    previous = previous.next;
                    current = current.next;
                }
                previous.next = current.next;
                current.next = null;
                size--;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void addFirst(int data) {

        Node node = new Node(data);
        if(addWhenSizeZero(node)) {
            return;
        }

        node.next = head;
        head = node;
        tail.next = head;
        size++;
    }

    public void addLast(int data) {

        Node node = new Node(data);
        if(addWhenSizeZero(node)) {
            return;
        }

        tail.next = node;
        tail = node;
        tail.next = head;
        size++;
    }

    public boolean search(int data) {

        return !_search(data).isEmpty();
    }

    public void deleteFirst() {

        if(deleteWhenSizeZeroOrOne()) {
            return;
        }

        Node node = head;
        head = head.next;
        node.next = null;
        tail.next = head;
        size--;
    }

    public void deleteLast() {

        if(deleteWhenSizeZeroOrOne()) {
            return;
        }

        Node node = head;
        while(node.next != tail) {
            node = node.next;
        }

        tail.next = null;
        tail = node;
        tail.next = head;
        size--;
    }

    public void delete(int data) {

        ArrayList<Node> nodesToBeDeleted = _search(data);
        _delete(nodesToBeDeleted);
    }

    public void printLinkedList() {

        System.out.print("LinkedList: ");
        Node current = head;
        do {
            if(current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        } while(current != head);
        System.out.println();
    }

    public static void main(String[] args) {

        CircularSinglyLinkedList object = new CircularSinglyLinkedList();
        object.addLast(1);
        object.addFirst(2);
        object.addLast(3);
        object.addFirst(4);
        object.printLinkedList();

        object.deleteFirst();
        object.deleteLast();
        object.deleteFirst();
        object.deleteLast();
        object.printLinkedList();

        object.addLast(1);
        object.addLast(2);
        object.addLast(3);
        object.addLast(2);
        object.addLast(4);
        object.addLast(2);
        object.addLast(5);
        object.printLinkedList();

        assert true == object.search(2);
        assert false == object.search(6);

        object.delete(2);
        object.printLinkedList();
    }
}
