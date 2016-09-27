package com.leetcode.easy;

/**
 * Created by SKapadia on 9/21/2016.
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode resultList = null;
        ListNode resultHead = null;
        ListNode tempNode;

        while(p1 != null && p2 != null) {

            if(p1.val <= p2.val) {
                tempNode = p1;
                p1 = p1.next;
            } else {
                tempNode = p2;
                p2 = p2.next;
            }
            tempNode.next = null;
            if(resultList == null) {
                resultHead = tempNode;
            } else {
                resultList.next = tempNode;
            }
            resultList = tempNode;
        }

        if(p1 == null && p2 != null) {
            if(resultList == null) {
                return p2;
            } else {
                resultList.next = p2;
            }
        }

        if(p2 == null && p1 != null) {
            if(resultList == null) {
                return p1;
            } else {
                resultList.next = p1;
            }
        }

        return resultHead;
    }
}
