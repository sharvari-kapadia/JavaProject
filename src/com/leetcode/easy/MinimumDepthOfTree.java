package com.leetcode.easy;

/**
 * Created by SKapadia on 9/15/2016.
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return 1;
        }

        if(root.left == null) {
            return minDepth(root.right) + 1;
        }

        if(root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
