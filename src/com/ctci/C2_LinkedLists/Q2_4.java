/*
 * 9.11.2015
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes
 * greater than or equal to x.
 */

package com.ctci.C2_LinkedLists;

import com.util.datastructures.LinkedListUtil;
import com.util.datastructures.MyLinkedList;

public class Q2_4 {

    public static void partitionLinkedList(MyLinkedList<String> myLinkedList, MyLinkedList.Node node) {

        MyLinkedList<String> smallerLinkedList = new MyLinkedList<String>();
        MyLinkedList<String> greaterLinkedList = new MyLinkedList<String>();
        MyLinkedList<String> equalLinkedList = new MyLinkedList<String>();

        MyLinkedList.Node currentNode = myLinkedList.getHead();
        String givenNodeData = (String)node.data;

        while(currentNode != null) {

            String currentNodeData = (String)currentNode.data;
            int compareResult = currentNodeData.compareTo(givenNodeData);
            currentNode = currentNode.next;
            myLinkedList.removeFirst();

            // move items less than x to smallerLinkedList
            if(compareResult < 0) {
                smallerLinkedList.addLast(currentNodeData);
            }
            // move items greater than z to greaterLinkedList
            else if (compareResult > 0){
                greaterLinkedList.addLast(currentNodeData);
            }
            // move items to equal to x to equalLinkedList
            else {
                equalLinkedList.addLast(currentNodeData);
            }
        }

        myLinkedList.reset();
        myLinkedList.append(smallerLinkedList);
        myLinkedList.append(equalLinkedList);
        myLinkedList.append(greaterLinkedList);
    }

    public static void main(String[] args) {

        MyLinkedList<String> myLinkedList = LinkedListUtil.createStringMyLinkedList();
        LinkedListUtil.printMyLinkedList(myLinkedList);

        partitionLinkedList(myLinkedList, myLinkedList.getHead().next.next); // passing 3rd element
        LinkedListUtil.printMyLinkedList(myLinkedList);
    }
}
