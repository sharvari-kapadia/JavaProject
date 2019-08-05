/*
 * 11.30.2015
 * You have two very large binary trees: Tl, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm
 * to decide if T2 is a subtree of Tl. A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree
 * of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.
 */

package com.ctci.C4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q4_8 {

    private class Node {
        int data;
        Node left;
        Node right;

        private Node(int data) {

            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private enum Direction {
        LEFT, RIGHT
    }

    private class BinaryTree {

        Node root;
        Direction lastDirection;

        private BinaryTree() {

            this.root = null;
            this.lastDirection = Direction.LEFT;
        }

        private Direction getDirection() {

            if(lastDirection.equals(Direction.LEFT)) {
                lastDirection = Direction.RIGHT;
            } else {
                lastDirection = Direction.LEFT;
            }
            return lastDirection;
        }

        private Node getRoot() {
            return this.root;
        }

        private void insert(int data) {

            Node node = new Node(data);
            if(root == null) {
                root = node;
                return;
            }

            Node current = root;
            while(current != null) {
                if(current.left == null) {
                    current.left = node;
                    return;
                } else if(current.right == null) {
                    current.right = node;
                    return;
                } else {
                    if(getDirection().equals(Direction.LEFT)) {
                        current = current.left;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    public Node createBinaryTree(ArrayList<Integer> dataList) {

        BinaryTree tree = new BinaryTree();
        for(int i : dataList) {
            tree.insert(i);
        }
        return tree.getRoot();
    }

    public ArrayList<Node> search(Node root, int data) {

        ArrayList<Node> arrayList = new ArrayList<>();
        if(root == null) {
            arrayList.add(null);
            return arrayList;
        }

        Node current;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            current = queue.remove();
            if(current.data == data) {
                arrayList.add(current);
            }

            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }

        return arrayList;
    }

    public boolean isSubTree(Node root1, Node root2) {
        if(root2 == null) {
            return true;
        }

        if(root1 == null) {
            return false;
        }

        ArrayList<Node> searchResult = search(root1, root2.data);
        for(Node newRoot1 : searchResult) {
            if(matchTree(newRoot1, root2)) {
                return true;
            }
        }
        return false;
    }

    private boolean matchTree(Node root1, Node root2) {

        if(root1 == null) {
            return false;
        }

        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();

        queue1.add(root1);
        queue2.add(root2);

        Node current1;
        Node current2;

        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            current1 = queue1.remove();
            current2 = queue2.remove();

            if(current1.data != current2.data) {
                return false;
            }

            if(current1.left != null) {
                queue1.add(current1.left);
            }
            if(current1.right != null) {
                queue1.add(current1.right);
            }

            if(current2.left != null) {
                queue2.add(current2.left);
            }
            if(current2.right != null) {
                queue2.add(current2.right);
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();

    }

    public static void main(String[] args) {

        Q4_8 q4_8 = new Q4_8();

        Node tree1 = q4_8.createBinaryTree(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        Node tree2 = q4_8.createBinaryTree(new ArrayList<>(Arrays.asList(3, 4, 6)));

        /* //Two occurrences of subtree
        Node tree1 = q4_8.createBinaryTree(new ArrayList<>(Arrays.asList(1, 3, 3, 4, 4, 6, 6)));
        Node tree2 = q4_8.createBinaryTree(new ArrayList<>(Arrays.asList(3, 4, 6)));
         */

        /* // No subtree
        Node tree1 = q4_8.createBinaryTree(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        Node tree2 = q4_8.createBinaryTree(new ArrayList<>(Arrays.asList(3, 4, 6, 7)));
        */

        System.out.println(q4_8.isSubTree(tree1, tree2));
    }
}
