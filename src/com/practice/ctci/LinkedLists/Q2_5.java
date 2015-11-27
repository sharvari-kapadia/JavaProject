/*
 * 9.11.2015
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in
 * reverse order, such that the Ts digit is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list.
 * EXAMPLE
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
 * Output: 2 -> 1 -> 9.That is, 912.
 * FOLLOW UP Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
 * Output: 9 -> 1 -> 2.That is, 912.
 */

package com.practice.ctci.LinkedLists;

import com.practice.ctci.tools.LinkedListUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Q2_5 {

    public static LinkedList<Integer> addNumbersReverseOrder(LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2) {

        return convertIntToReverseLinkedList(convertReverseLinkedListToInt(linkedList1) + convertReverseLinkedListToInt(linkedList2));
    }

    public static LinkedList<Integer> addNumbersForwardOrder(LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2) {

        return convertIntToForwardLinkedList(convertForwardLinkedListToInt(linkedList1) + convertForwardLinkedListToInt(linkedList2));
    }

    // INPUT: linkedList z -> y -> x
    // OUTPUT: integer xyz
    private static int convertReverseLinkedListToInt(LinkedList<Integer> linkedList) {

        ListIterator listIterator = linkedList.listIterator();
        int number = 0;
        int i = 0;
        while(listIterator.hasNext()) {
            number += (Integer)listIterator.next() * (int)Math.pow(10, i);
            i++;
        }
        return number;
    }

    // INPUT: linkedList x -> y -> z
    // OUTPUT: integer xyz
    private static int convertForwardLinkedListToInt(LinkedList<Integer> linkedList) {

        ListIterator listIterator = linkedList.listIterator();
        int number = 0;
        int i = linkedList.size() - 1;
        while(listIterator.hasNext()) {
            number += (Integer)listIterator.next() * (int)Math.pow(10, i);
            i--;
        }
        return number;
    }

    // INPUT: integer xyz
    // OUTPUT: linkedList z -> y -> x
    private static LinkedList<Integer> convertIntToReverseLinkedList(int number) {

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        while(number != 0) {
            linkedList.addLast(number % 10);
            number = number / 10;
        }
        return linkedList;
    }

    // INPUT: integer xyz
    // OUTPUT: linkedList x -> y -> z
    private static LinkedList<Integer> convertIntToForwardLinkedList(int number) {

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        while(number != 0) {
            linkedList.addFirst(number % 10);
            number = number / 10;
        }
        return linkedList;
    }

    public static void main(String[] args) {
        LinkedList<Integer> reverseLinkedList1 = new LinkedList<Integer>(Arrays.asList(7, 1, 6));
        LinkedList<Integer> reverseLinkedList2 = new LinkedList<Integer>(Arrays.asList(5, 9, 2));
        LinkedList<Integer> forwardLinkedList1 = new LinkedList<Integer>(Arrays.asList(6, 1, 7));
        LinkedList<Integer> forwardLinkedList2 = new LinkedList<Integer>(Arrays.asList(2, 9, 5));

        //System.out.println(convertReverseLinkedListToInt(reverseLinkedList1));
        //System.out.println(convertReverseLinkedListToInt(reverseLinkedList2));
        //System.out.println(convertForwardLinkedListToInt(forwardLinkedList1));
        //System.out.println(convertForwardLinkedListToInt(forwardLinkedList2));

        //Util.printLinkedList(convertIntToReverseLinkedList(617));
        //Util.printLinkedList(convertIntToReverseLinkedList(295));
        //Util.printLinkedList(convertIntToForwardLinkedList(617));
        //Util.printLinkedList(convertIntToForwardLinkedList(295));

        LinkedListUtil.printLinkedList(addNumbersReverseOrder(reverseLinkedList1, reverseLinkedList2));
        LinkedListUtil.printLinkedList(addNumbersForwardOrder(forwardLinkedList1, forwardLinkedList2));
    }
}
