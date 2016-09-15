package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by SKapadia on 9/15/2016.
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversal2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null) {
            return resultList;
        }

        Queue<TreeNode> primaryQueue = new LinkedList<>();
        Queue<TreeNode> secondaryQueue = new LinkedList<>();
        Queue<TreeNode> tempQueue;
        primaryQueue.add(root);
        TreeNode node;

        while(!primaryQueue.isEmpty() || !secondaryQueue.isEmpty()) {

            List<Integer> arrayList = new ArrayList<>();
            while(!primaryQueue.isEmpty()) {

                node = primaryQueue.remove();
                arrayList.add(node.val);

                if(node.left != null) {
                    secondaryQueue.add(node.left);
                }
                if(node.right != null) {
                    secondaryQueue.add(node.right);
                }
            }
            resultList.add(0, arrayList);

            tempQueue = primaryQueue;
            primaryQueue = secondaryQueue;
            secondaryQueue = tempQueue;
        }
        return resultList;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0, 1);
        list.add(0, 2);
        list.add(0, 3);

        System.out.println(list.toString());
    }
}
