/*
 * 9.11.2015
 * Implement a function to check if a linked list is a palindrome.
 */

package com.practice.ctci.LinkedLists;
import com.practice.ctci.tools.Util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class Q2_7 {

    // Method 1: By reversing the LinkedList
    public static boolean isPalindromeByReversingLinkedList(LinkedList<String> linkedList) {
        return linkedList.equals(reverseLinkedList(linkedList));
    }

    private static LinkedList<String> reverseLinkedList(LinkedList linkedList) {

        LinkedList<String> reverseLinkedList = new LinkedList<String>();
        ListIterator<String> listIterator = linkedList.listIterator();
        while(listIterator.hasNext()) {
            reverseLinkedList.addFirst(listIterator.next());
        }
        return reverseLinkedList;
    }

    // Method 2a: Using stack (where stack is created by making use of LinkedList size)
    public static boolean isPalindromeUsingStack1(LinkedList<String> linkedList) {

        Stack<String> stack = getStackFromSecondHalfLinkedListUsingLinkedListSize(linkedList);
        return compareLinkedListAndStack(linkedList, stack);
    }

    // Method 2b: Using stack (where stack is created WITHOUT making use of LinkedList size)
    public static boolean isPalindromeUsingStack2(LinkedList<String> linkedList) {

        Stack<String> stack = getStackFromSecondHalfLinkedListWithoutUsingLinkedListSize(linkedList);
        return compareLinkedListAndStack(linkedList, stack);
    }

    private static boolean compareLinkedListAndStack(LinkedList<String> linkedList, Stack<String> stack) {

        ListIterator<String> linkedListIterator = linkedList.listIterator();

        while(!stack.isEmpty()) {

            String LHS = stack.pop() ;
            String RHS = linkedListIterator.next();
            if(!LHS.equals(RHS)) {
                return false;
            }
        }
        return true;
    }

    private static Stack<String> getStackFromSecondHalfLinkedListUsingLinkedListSize(LinkedList<String> linkedList) {

        int linkedListLength = linkedList.size();
        ListIterator<String> listIterator = linkedList.listIterator((linkedListLength + 1) / 2);
        Stack<String> stack = new Stack<String>();

        while(listIterator.hasNext()) {
            stack.push(listIterator.next());
        }

        return stack;
    }

    private static Stack<String> getStackFromSecondHalfLinkedListWithoutUsingLinkedListSize(LinkedList<String> linkedList) {

        ListIterator<String> slowListIterator = linkedList.listIterator();
        ListIterator<String> fastListIterator = linkedList.listIterator();
        Stack<String> stack = new Stack<String>();

        while(fastListIterator.hasNext()) {
            slowListIterator.next();
            fastListIterator.next();
            if(fastListIterator.hasNext()) {
                fastListIterator.next();
            } else {
                break;
            }
        }

        while(slowListIterator.hasNext()) {
            stack.push(slowListIterator.next());
        }

        return stack;
    }

    private static void printPalindromeResult(boolean result) {
        if(result) {
            System.out.println("Given LinkedList is a palindrome.");
        } else {
            System.out.println("Given LinkedList is NOT a palindrome.");
        }
    }

    public static void main(String[] args) {

        LinkedList<String> linkedList1 = new LinkedList<String>(Arrays.asList("r", "a", "c", "e", "c", "a", "r"));
        Util.printLinkedList(linkedList1);
        printPalindromeResult(isPalindromeByReversingLinkedList(linkedList1));
        printPalindromeResult(isPalindromeUsingStack1(linkedList1));
        printPalindromeResult(isPalindromeUsingStack2(linkedList1));

        LinkedList<String> linkedList2 = new LinkedList<String>(Arrays.asList("s", "h", "a", "r", "v", "a", "r", "i"));
        Util.printLinkedList(linkedList2);
        printPalindromeResult(isPalindromeByReversingLinkedList(linkedList2));
        printPalindromeResult(isPalindromeUsingStack1(linkedList2));
        printPalindromeResult(isPalindromeUsingStack2(linkedList2));
    }
}
