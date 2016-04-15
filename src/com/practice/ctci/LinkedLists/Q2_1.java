/*
 * 9.8.2015
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP How would you solve this problem if a temporary buffer is not allowed?
 */

package com.practice.ctci.LinkedLists;

import com.practice.ctci.datastructures.LinkedListUtil;
import com.practice.ctci.datastructures.MyLinkedList;

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

    public static void main(String[] args) throws Exception {

        // Method 1: using temporary buffer - HashSet
        LinkedList<String> linkedList1 = LinkedListUtil.createStringLinkedList();
        LinkedListUtil.printLinkedList(linkedList1);
        removeDuplicatesFromUnsortedLinkedListUsingHashSet(linkedList1);
        LinkedListUtil.printLinkedList(linkedList1);

        System.out.println("---------------------------------");

        // Method 2: Without using temporary buffer
        MyLinkedList<String> myLinkedList2 = LinkedListUtil.createStringMyLinkedList();
        LinkedListUtil.printMyLinkedList(myLinkedList2);
        removeDuplicatesFromUnsortedLinkedList(myLinkedList2);
        LinkedListUtil.printMyLinkedList(myLinkedList2);
    }
}
