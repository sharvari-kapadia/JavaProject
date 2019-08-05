package com.leetcode.easy;

/**
 * Created by SKapadia on 9/7/2016.
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        if(head == null) {
            return head;
        }

        ListNode node1 = head;
        ListNode node2 = node1.next;
        node1.next = null;

        while(node2 != null) {
            node1 = node2;
            node2 = node2.next;
            node1.next = head;
            head = node1;
        }
        return head;
    }
}
