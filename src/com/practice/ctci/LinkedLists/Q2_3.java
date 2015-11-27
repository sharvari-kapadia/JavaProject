/*
 * 9.9.2015
 * Implement an algorithm to delete a node in the "middle" of a singly linked list, given only access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a -> b -> c -> d -> e
 * Result: nothing is returned, but the new linked list looks like a -> b -> d -> e
 *
 * FOLLOW UP (by AS) When is this algorithm not optimal?
 * Answer: When node data is huge.
 */

package com.practice.ctci.LinkedLists;

import com.practice.ctci.tools.LinkedListUtil;
import com.practice.ctci.tools.MyLinkedList;

public class Q2_3 {

    public static void deleteNode(MyLinkedList.Node node) {

        MyLinkedList.Node nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
        nextNode.next = null;
    }

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = LinkedListUtil.createStringMyLinkedList();
        LinkedListUtil.printMyLinkedList(myLinkedList);

        deleteNode(myLinkedList.getHead().next.next); // passing 3rd element
        LinkedListUtil.printMyLinkedList(myLinkedList);
    }
}
