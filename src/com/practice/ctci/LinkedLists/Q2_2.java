/*
 * 9.9.2015
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */

package com.practice.ctci.LinkedLists;

import com.practice.ctci.tools.Util;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.ListIterator;

public class Q2_2 {

    // Returns kth to last element of the singly linked list, where 1 <= k <= linkedListLength
    public static Object getKthElement(LinkedList<String> linkedList, int k) {

        int linkedListLength = linkedList.size();
        if(k < 1 || k > linkedListLength) {
            throw new InvalidParameterException("Value of k has to be such that 1 <= k <= " + linkedListLength + " (length of LinkedList).");
        }

        if(k == 1) {
            return linkedList.getLast();
        }

        if(k == linkedListLength) {
            return linkedList.getFirst();
        }

        ListIterator slowIterator = linkedList.listIterator();
        ListIterator fastIterator = linkedList.listIterator(k);
        while(fastIterator.hasNext()) {
            fastIterator.next();
            slowIterator.next();
        }
        return slowIterator.next();
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = Util.createStringLinkedList();
        Util.printLinkedList(linkedList);
        int k = 4;
        System.out.println("kth to last element of the LinkedList is " + getKthElement(linkedList, k) + ", where k = " + k + "\n");
    }
}
