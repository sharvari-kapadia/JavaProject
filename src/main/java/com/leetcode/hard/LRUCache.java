package com.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by skapadia on 9/28/2016.
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

    public int counter;

    public class ListNode {
        int key;
        int value;
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<ListNode> myList;
    HashMap<Integer, ListNode> myMap;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.myList = new LinkedList<>();
        this.myMap = new HashMap<>();
    }

    public int get(int key) {
        ListNode node;
        if(!myMap.containsKey(key)) {
            return -1;
        }
        node = myMap.get(key);
        myList.remove(node);
        myList.addLast(node);
        return node.value;
    }

    public void set(int key, int value) {
        ListNode node;
        if(myMap.size() >= capacity) {
            node = myList.removeFirst();
            myMap.remove(node.key);
        }
        if(myMap.containsKey(key)) {
            node = myMap.get(key);
            myMap.remove(key);
            myList.remove(node);
            node.value = value;
        } else {
            node = new ListNode(key, value);
        }
        myMap.put(key, node);
        myList.addLast(node);
    }

    public static void main(String[] args) {
    }

}
