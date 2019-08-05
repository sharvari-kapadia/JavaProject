package com.leetcode.medium;

/**
 * Created by SKapadia on 9/7/2016.
 */
public class ReverseLinkedList2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) {
            return head;
        }

        int index = 1;
        ListNode curr = head;
        ListNode nodeX = null;
        while (index < m) {
            nodeX = curr;
            curr = curr.next;
            index++;
        }
        ListNode headToBeReversed = curr;

        while (index < n) {
            curr = curr.next;
            index++;
        }
        ListNode nodeY = curr.next;
        curr.next = null;

        ListNode[] newNodes = reverse(headToBeReversed);

        // newNodes[0] ~ newHead
        // newNodes[1] ~ newTail
        if (nodeX != null) {
            nodeX.next = newNodes[0];
        } else {
            head = newNodes[0];
        }

        newNodes[1].next = nodeY;
        return head;
    }

    private ListNode[] reverse(ListNode head) {

        ListNode node1 = head;
        ListNode node2 = node1.next;
        ListNode tail = node1;
        node1.next = null;

        while (node2 != null) {
            node1 = node2;
            node2 = node2.next;
            node1.next = head;
            head = node1;
        }
        return new ListNode[]{head, tail};
    }
}
