package com.leetcode.medium;

/**
 * Created by SKapadia on 9/11/2016.
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null) {
            return null;
        }

        ListNode node1 = head;
        ListNode node2 = head;
        for(int i = 0; i < n; i++) {
            node2 = node2.next;
        }

        if(node2 == null) {
            head = head.next;
            node1.next = null;
        } else {
            while(node2.next != null) {
                node1 = node1.next;
                node2 = node2.next;
            }
            ListNode temp = node1.next;
            node1.next = node1.next.next;
            temp.next = null;
        }
        return head;
    }
}
