package com.leetcode.medium;

/**
 * Created by skapadia on 10/24/2016.
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode head = null;
        ListNode curr = null;
        int carry = 0;
        int tempAns;
        int ans;

        while(n1 != null || n2 != null) {
            tempAns = carry;
            if(n1 != null) {
                tempAns += n1.val;
                n1 = n1.next;
            }
            if(n2 != null) {
                tempAns += n2.val;
                n2 = n2.next;
            }
            ans = tempAns % 10;
            carry = tempAns / 10;
            ListNode node = new ListNode(ans);

            if(head == null) {
                head = node;
                curr = node;
            } else {
                curr.next = node;
                curr = curr.next;
            }
        }
        if(carry != 0) {
            curr.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {

        AddTwoNumbers object = new AddTwoNumbers();

        ListNode l1 = object.new ListNode(2);
        l1.next = object.new ListNode(4);
        l1.next.next = object.new ListNode(1);

        ListNode l2 = object.new ListNode(5);
        l2.next = object.new ListNode(6);
        l2.next.next = object.new ListNode(9);

        ListNode ans = object.addTwoNumbers(l1, l2);
        while(ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        // ans = 7 -> 0 -> 1 -> 1
    }
}
