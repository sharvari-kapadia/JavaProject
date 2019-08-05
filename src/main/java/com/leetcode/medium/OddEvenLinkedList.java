package com.leetcode.medium;

/**
 * Created by SKapadia on 7/9/2016.
 * https://leetcode.com/problems/odd-even-linked-list/
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class OddEvenLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public class MyLinkedList {

        ListNode head;
        ListNode tail;
        MyLinkedList() {
            head = null;
            tail = null;
        }

        void add(ListNode node) {

            if(head == null) {
                head = node;
                tail = node;
                return;
            }

            tail.next = node;
            tail = node;
        }

        void add(int val) {

            ListNode node = new ListNode(val);
            if(head == null) {
                head = node;
                tail = node;
                return;
            }

            tail.next = node;
            tail = node;
        }
    }

    public OddEvenLinkedList() {

    }

    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        MyLinkedList ll1 = new MyLinkedList();
        MyLinkedList ll2 = new MyLinkedList();

        ListNode p1 = head;
        ListNode p2;
        boolean odd = true;
        while(p1 != null) {
            p2 = p1.next;
            p1.next = null;
            if(odd) {
                ll1.add(p1);
            } else {
                ll2.add(p1);
            }
            odd = !odd;
            p1 = p2;
        }

        ll1.tail.next = ll2.head;
        ll1.tail = ll2.tail;
        return ll1.head;
    }

    public ListNode createLinkedList(ArrayList<Integer> dataList) {

        MyLinkedList ll = new MyLinkedList();
        for(int i : dataList) {
            ll.add(i);
        }
        return ll.head;
    }

    public static void main(String[] args) {

        OddEvenLinkedList object = new OddEvenLinkedList();
        ListNode head = object.createLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3)));
        ListNode newHead = object.oddEvenList(head);
        System.out.println("");
    }
}
