/*
 * 9.11.2015
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to
 * make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 */

package com.ctci.C2_LinkedLists;

import com.util.datastructures.LinkedListUtil;
import com.util.datastructures.MyLinkedList;

public class Q2_6 {

    public static String getBeginningOfCircularLinkedList(MyLinkedList circularLinkedList) {

        MyLinkedList.Node slow = circularLinkedList.getHead();
        MyLinkedList.Node fast = circularLinkedList.getHead();

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while(slow.data != fast.data);

        slow = circularLinkedList.getHead();

        while(slow.data != fast.data) {
            slow = slow.next;
            fast = fast.next;
        }

        return (String)slow.data;
    }

    public static void main(String[] args) {

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.addLast("A");
        myLinkedList.addLast("B");
        myLinkedList.addLast("C");
        myLinkedList.addLast("D");
        myLinkedList.addLast("E");

        MyLinkedList.Node beginning = myLinkedList.getHead().next.next;
        // Print the circular linked list before pointing the tail to beginning
        LinkedListUtil.printMyCircularLinkedList(myLinkedList, beginning);

        // Pointing the tail i.e. "E" to "C" to generate linkedList A -> B -> C -> D -> E -> C
        myLinkedList.getTail().next = beginning;
        System.out.println(getBeginningOfCircularLinkedList(myLinkedList));
    }
}
