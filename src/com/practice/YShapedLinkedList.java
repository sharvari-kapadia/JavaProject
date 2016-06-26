package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SKapadia on 6/25/2016.
 */
public class YShapedLinkedList {

    private class Node {

        int data;
        Node next;
        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private class LinkedList {

        private Node head;
        private Node tail;

        private LinkedList() {
            this.head = null;
            this.tail = null;
        }

        private Node getHead() {
            return this.head;
        }

        private Node getTail() {
            return this.tail;
        }

        private void setTail(Node node) {
            this.tail = node;
        }

        private void insert(int data) {

            Node node = new Node(data);
            if(head == null) {
                head = node;
                tail = node;
                return;
            }

            tail.next = node;
            tail = node;
        }
    }

    private LinkedList createLinkedList(ArrayList<Integer> dataList) {

        LinkedList ll = new LinkedList();
        for(int i = 0; i < dataList.size(); i++) {
            ll.insert(dataList.get(i));
        }
        return ll;
    }

    public LinkedList[] createTwoLinkedLists(ArrayList<Integer> dataList1, ArrayList<Integer> dataList2) {

        return new LinkedList[]{createLinkedList(dataList1), createLinkedList(dataList2)};
    }

    public LinkedList[] createTwoYShapedLinkedLists(ArrayList<Integer> dataList1,
                                                    ArrayList<Integer> dataList2,
                                                    int intersectionIndex) {

        LinkedList ll1 = createLinkedList(dataList1);
        LinkedList ll2 = createLinkedList(dataList2);

        Node node = ll1.getHead();
        for(int i = 0; i < intersectionIndex; i++) {

            if(node != null) {
                node = node.next;
            }
        }
        ll2.getTail().next = node;
        ll2.setTail(ll1.getTail());

        return new LinkedList[]{ll1, ll2};
    }

    private int getSize(LinkedList linkedList) {

        Node node = linkedList.getHead();
        int size = 0;
        while(node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    private Node incrementNodeByK(Node node, int diff) {
        for(int i = 0; i < diff; i++) {
            if(node != null) {
                node = node.next;
            }
        }
        return node;
    }

    public boolean isYShaped(LinkedList[] linkedLists) {
        return linkedLists[0].getTail() == linkedLists[1].getTail();
    }

    public Node getIntersection(LinkedList[] linkedLists) {

        LinkedList ll1 = linkedLists[0];
        LinkedList ll2 = linkedLists[1];

        int size1 = getSize(ll1);
        int size2 = getSize(ll2);

        Node node1 = ll1.getHead();
        Node node2 = ll2.getHead();

        int diff = size1 - size2;
        if(diff > 0) {
            node1 = incrementNodeByK(node1, diff);
        } else if(diff < 0) {
            node2 = incrementNodeByK(node2, -diff);
        }

        while(node1 != null && node2 != null) {

            if(node1 == node2) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return null;
    }

    public static void main(String[] args) {

        ArrayList<Integer> dataList1 = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> dataList2 = new ArrayList(Arrays.asList(6, 7, 8));

        YShapedLinkedList object1 = new YShapedLinkedList();
        boolean isYShaped1 = object1.isYShaped(object1.createTwoLinkedLists(dataList1, dataList2));
        assert isYShaped1 == false;

        for(int i = 0; i < dataList1.size(); i++) {

            YShapedLinkedList object2 = new YShapedLinkedList();
            LinkedList[] linkedLists = object2.createTwoYShapedLinkedLists(dataList1, dataList2, i);
            assert object2.isYShaped(linkedLists) == true;
            assert object2.getIntersection(linkedLists).data == dataList1.get(i);
        }
    }
}
