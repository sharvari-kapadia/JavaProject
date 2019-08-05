package com.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by skapadia on 9/16/2016.
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedArrays {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode currListNode;
        ListNode returnList = null;
        ListNode returnListHead = null;

        while(!pq.isEmpty()) {

            currListNode = pq.poll();
            if(currListNode != null && currListNode.next != null) {
                pq.add(currListNode.next);
            }
            currListNode.next = null;
            if(returnList == null) {
                returnListHead = currListNode;
            } else {
                returnList.next = currListNode;
            }
            returnList = currListNode;
        }
        return returnListHead;
    }
}
