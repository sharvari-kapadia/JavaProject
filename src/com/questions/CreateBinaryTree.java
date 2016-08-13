/*
* Input:    child   parent  isLeft
*           15      20      true
*           19      80      true
*           17      20      false
*           16      80      false
*           80      50      false
*           50      null    false
*           20      50      true
* Output: binary tree
* */
package com.questions;

import java.util.HashMap;

/**
 * Created by SKapadia on 7/25/2016.
 */
public class CreateBinaryTree {

    public class Node {
        Integer data;
        Node left;
        Node right;
        public Node(Integer data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private HashMap<Integer, Node> hMap;
    private Node root;

    CreateBinaryTree() {
        hMap = new HashMap<>();
        root = null;
    }

    // Assuming that if the given parent is null, the given child is root.
    public void addNode(Integer child, Integer parent, boolean isLeft) {

        Node childNode;
        Node parentNode;

        if (parent == null) {
            parent = -1;
        }
        if (hMap.containsKey(parent)) {
            parentNode = hMap.get(parent);
        } else {
            parentNode = new Node(parent);
            hMap.put(parent, parentNode);
        }

        if (hMap.containsKey(child)) {
            childNode = hMap.get(child);
        } else {
            childNode = new Node(child);
            hMap.put(child, childNode);
        }

        if (isLeft) {
            parentNode.left = childNode;
        } else {
            parentNode.right = childNode;
        }

        if (parent == -1) {
            root = childNode;
        }
    }

    public static void main(String[] args) {

        CreateBinaryTree object = new CreateBinaryTree();
        object.addNode(15, 20, true);
        object.addNode(19, 80, true);
        object.addNode(17, 20, false);
        object.addNode(16, 80, false);
        object.addNode(80, 50, false);
        object.addNode(50, null, false);
        object.addNode(20, 50, true);
        System.out.println(object.root.data);
    }
}
