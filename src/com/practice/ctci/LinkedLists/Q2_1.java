/*
 * 9.8.2015
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP How would you solve this problem if a temporary buffer is not allowed?
 */

package com.practice.ctci.LinkedLists;

import com.practice.ctci.tools.MyLinkedList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

public class Q2_1 {

    // Using HashSet as temporary buffer
    public static void removeDuplicatesFromUnsortedLinkedListUsingHashSet(LinkedList linkedList) {

        HashSet hashSet = new HashSet();
        ListIterator listIterator = linkedList.listIterator();
        while(listIterator.hasNext()) {
            Object currentItem = listIterator.next();
            if(hashSet.contains(currentItem)) {
                listIterator.remove();
            } else {
                hashSet.add(currentItem);
            }
        }
    }

    // Without using temporary buffer
    public static void removeDuplicatesFromUnsortedLinkedList(MyLinkedList myLinkedList) throws Exception {

       MyLinkedList.Node outer = myLinkedList.getHead();
        while(outer != null) {
            MyLinkedList.Node inner = outer.next;
            while(inner != null) {
                MyLinkedList.Node innerNext = inner.next;
                if(inner.data == outer.data) {
                    myLinkedList.remove(inner);
                }
                inner = innerNext;
            }
            outer = outer.next;
        }
    }

    // Create LinkedList
    public static LinkedList createLinkedList() {

        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("c");
        linkedList.add("c");
        linkedList.add("f");
        linkedList.add("k");
        linkedList.add("b");
        linkedList.add("a");

        return linkedList;
    }

    // Create MyLinkedList
    public static MyLinkedList createMyLinkedList() {

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
    public static void print(LinkedList linkedList) {

        ListIterator listIterator = linkedList.listIterator();
        int length = linkedList.size();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next());
            if(listIterator.nextIndex() != length) {
                System.out.print(" -> ");
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) throws Exception {

        // Method 1: using temporary buffer - HashSet
        LinkedList linkedList1 = createLinkedList();
        print(linkedList1);
        removeDuplicatesFromUnsortedLinkedListUsingHashSet(linkedList1);
        print(linkedList1);

        System.out.println("---------------------------------");

        // Method 2: Without using temporary buffer
        MyLinkedList myLinkedList2 = createMyLinkedList();
        MyLinkedList.print(myLinkedList2);
        removeDuplicatesFromUnsortedLinkedList(myLinkedList2);
        MyLinkedList.print(myLinkedList2);
    }
}
