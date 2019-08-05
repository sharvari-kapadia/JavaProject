package com.leetcode.easy;

/**
 * Created by skapadia on 9/30/2016.
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {

        // Find length
        int length = 0;
        ListNode p1 = head;
        while(p1 != null) {
            length++;
            p1 = p1.next;
        }

        if(length <= 1) {
            return true;
        }
        if(length == 2) {
            return head.val == head.next.val;
        }

        // By this time we know that the length of LL is at-least 3
        // Finding the center point
        p1 = head;
        ListNode p2 = head.next;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // Separate two LLs
        ListNode head2 = p1.next;
        p1.next = null;

        // Reverse first LL. Length of first LL will at-least be 1.
        head = this.reverse(head);
        ListNode head1 = head;
        if(length % 2 != 0) {
            head1 = head1.next;
        }

        // Compare two LLs. Length of both LLs should be same.
        p1 = head1;
        p2 = head2;
        while(p1 != null && p2 != null) {

            if(p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {

        if(head == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = p1.next;
        p1.next = null;

        while(p2 != null) {
            p1 = p2;
            p2 = p2.next;
            p1.next = head;
            head = p1;
        }
        return p1;
    }

    public static void main(String[] args) {
        PalindromeLinkedList object = new PalindromeLinkedList();
        ListNode head = object.new ListNode(1);
        object.isPalindrome(head);

    }
}
