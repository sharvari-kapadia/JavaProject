package com.leetcode.easy;

/**
 * Created by SKapadia on 9/15/2016.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;

        while(p1 != null && p2 != null) {

            if(p2.val == p1.val) {

                p1.next = p2.next;
                p2.next = null;
                p2 = p1.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }

        return head;
    }
}
