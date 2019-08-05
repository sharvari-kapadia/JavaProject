package com.leetcode.easy;

/**
 * Created by SKapadia on 9/27/2016.
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return sum(root, 0, false);
    }

    private int sum(TreeNode node, int val, boolean isLeft) {

        if(isLeft && node.left == null && node.right == null) {
            val += node.val;
        }

        if(node.left != null) {
            val = sum(node.left, val, true);
        }

        if(node.right != null) {
            val =   sum(node.right, val, false);
        }
        return val;
    }
}
