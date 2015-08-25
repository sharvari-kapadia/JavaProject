package com.mindsmapped.hw4.PositiveIntegerDoublyLinkedList;

public class Node {
    public int data;
    public Node next;
    public Node prev;

    public static void main(String args[]) {

        DoublyList l = new DoublyList();
        l.pushFront(0);
        l.pushFront(1);
        l.pushFront(2);

        l.pushBack(10);
        l.pushBack(11);
        l.pushBack(12);

        System.out.println(l.search(5));
    }
}
