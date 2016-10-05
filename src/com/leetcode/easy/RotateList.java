package com.leetcode.easy;

/**
 * Created by skapadia on 10/4/2016.
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || k < 0) {
            return null;
        }

        int n = 0;
        ListNode node = head;
        while(node != null) {
            node = node.next;
            n++;
        }

        k = k % n;
        if(k == 0) {
            return head;
        }

        node = head;
        for(int i = 0; i < (n - k - 1); i++) {
            node = node.next;
        }

        ListNode newHead = node.next;
        node.next = null;
        node = newHead;

        while(node != null && node.next != null) {
            node = node.next;
        }
        node.next = head;
        return newHead;
    }
}
