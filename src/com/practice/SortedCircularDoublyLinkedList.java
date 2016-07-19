package com.practice;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by SKapadia on 7/15/2016.
 */
public class SortedCircularDoublyLinkedList {

    public class Node {
        int data;
        Node prev;
        Node next;
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    SortedCircularDoublyLinkedList() {

        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // To be used when size > 2
    private void addBefore(Node newNode, Node node) {

        boolean isNodeHead = false;
        if(node == head) {
            isNodeHead = true;
        }
        Node prevNode = node.prev;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = node;
        node.prev = newNode;

        if(isNodeHead) {
            head = newNode;
        }
        size++;
    }

    // To be used when size > 2
    private void addLast(Node node) {

        tail.next = node;
        node.prev = tail;
        node.next = head;
        head.prev = node;
        tail = node;
        size++;
    }

    // This API will always return consecutive nodes
    private ArrayList<Node> _search(int data) {

        ArrayList<Node> resultList = new ArrayList<>();

        if(getSize() == 0) {
            return resultList;
        }

        Node current = head;
        do {
            if(current.data == data) {
                resultList.add(current);
            }
            if(!resultList.isEmpty() && current.data != resultList.get(0).data) {
                return resultList;
            }
            current = current.next;
        } while(current != head);

        return resultList;
    }

    // Parameter nodes passed here should always be consecutive nodes
    private void _delete(ArrayList<Node> nodes) {

        if(!nodes.isEmpty()) {
            if(getSize() == 1) {
                head = null;
                tail = null;
                size--;
                return;
            }

            Node node1 = nodes.get(0).prev;
            Node node2 = nodes.get(nodes.size() - 1).next;
            node1.next = node2;
            node2.prev = node1;

            Node current;
            for(int i = 0; i < nodes.size(); i++) {
                current = nodes.get(i);
                current.prev = null;
                current.next = null;
                if(current == head) {
                    head = node2;
                }
                if(current == tail) {
                    tail = node1;
                }
            }

            setSize(getSize() - nodes.size());

            if(getSize() == 1) {
                head = node1;
                tail = node1;
                return;
            }

            if(getSize() == 0) {
                head = null;
                tail = null;
                return;
            }
        }
    }

    public void insert(int data) {

        Node node = new Node(data);
        if(getSize() == 0) {
            node.next = node;
            node.prev = node;
            head = node;
            tail = node;
            size++;
            return;
        }

        Node current = head;
        do {
            if(data <= current.data) {
                addBefore(node, current);
                return;
            } else if(data > current.data) {
                current = current.next;
            }
        } while(current != head);

        addLast(node);
    }

    public boolean search(int data) {
        return !_search(data).isEmpty();
    }

    public void delete(int data) {

        ArrayList<Node> nodesToBeDeleted = _search(data);
        if(!nodesToBeDeleted.isEmpty()) {
            _delete(nodesToBeDeleted);
        }
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void printLinkedList() {

        System.out.print("LinkedList: ");
        Node current = head;
        for(int i = 0; i < getSize(); i++) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        SortedCircularDoublyLinkedList object = new SortedCircularDoublyLinkedList();
        object.printLinkedList();
        object.insert(4);
        object.insert(4);
        object.insert(6);
        object.insert(8);
        object.insert(10);
        object.insert(10);
        object.insert(10);
        object.printLinkedList();
        object.delete(4);
        object.delete(10);
        object.printLinkedList();
        assert false == object.search(3);
    }
}
