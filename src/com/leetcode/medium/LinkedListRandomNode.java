package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by SKapadia on 8/27/2016.
 */
public class LinkedListRandomNode {

    /**
     * Definition for singly-linked list. */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    ArrayList<ListNode> list;
    int size;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {

        list = new ArrayList<>();
        ListNode node = head;
        while(node != null) {
            list.add(node);
            node = node.next;
        }
        size = list.size();
    }

    /** Returns a random node's value. */
    public int getRandom() {

        return list.get(new Random().nextInt(size)).val;
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        LinkedListRandomNode object = new LinkedListRandomNode(head);
        for(int i = 0; i < 100; i++) {
            System.out.print(object.getRandom() + " ");
        }

    }
}
