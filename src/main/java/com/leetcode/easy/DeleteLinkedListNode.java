package com.leetcode.easy;

/**
 * Created by SKapadia on 7/20/2016.
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteLinkedListNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode head;
    public void addFirst(int data) {

        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
            return;
        }

        node.next = head;
        head = node;
    }

    public void deleteNode(ListNode node) {

        if(node != null) {
            boolean isHead = false;
            if(node == head) {
                isHead = true;
            }
            ListNode nextNode = node.next;
            if(nextNode != null) {
                node.val = nextNode.val;
                node.next = nextNode.next;
                nextNode.next = null;
                if (isHead) {
                    head = nextNode;
                }
            }
        }
    }

    public static void main(String[] args) {

        DeleteLinkedListNode object = new DeleteLinkedListNode();
        object.addFirst(1);
        object.addFirst(2);
        object.addFirst(3);
        object.addFirst(4);
        object.deleteNode(object.head);
    }
}
