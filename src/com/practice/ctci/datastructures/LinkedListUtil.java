package com.practice.ctci.datastructures;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListUtil {

    // Create LinkedList
    public static LinkedList<String> createStringLinkedList() {

        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("b");
        linkedList.add("f");
        linkedList.add("a");

        return linkedList;
    }

    // Create MyLinkedList
    public static MyLinkedList<String> createStringMyLinkedList() {

        MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
        myLinkedList.addLast("a");
        myLinkedList.addLast("c");
        myLinkedList.addLast("d");
        myLinkedList.addLast("f");
        myLinkedList.addLast("d");
        myLinkedList.addLast("c");
        myLinkedList.addLast("a");

        return myLinkedList;
    }

    // Print given LinkedList
    public static void printLinkedList(LinkedList linkedList) {

        ListIterator listIterator = linkedList.listIterator();
        int length = linkedList.size();
        System.out.println("");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next());
            if(listIterator.nextIndex() != length) {
                System.out.print(" -> ");
            }
        }
        System.out.println("");
    }

    // Print given myLinkedList
    public static void printMyLinkedList(MyLinkedList myLinkedList) {

        MyLinkedList.Node current = myLinkedList.getHead();
        System.out.println("");
        while(current != null) {
            System.out.print(current.data);
            if(current != myLinkedList.getTail()) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println("");
    }

    // Prints circular linkedList
    // Use this method BEFORE making the circular connection within the linkedList
    public static void printMyCircularLinkedList(MyLinkedList myLinkedList, MyLinkedList.Node beginning) {

        MyLinkedList.Node current = myLinkedList.getHead();
        System.out.println("");
        while(current != null) {
            System.out.print(current.data);
            if(current != myLinkedList.getTail()) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.print(" -> " + beginning.data + "\n");
    }
}
