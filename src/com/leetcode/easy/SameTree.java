package com.leetcode.easy;

/**
 * Created by SKapadia on 9/15/2016.
 * https://leetcode.com/problems/same-tree/
 *
 */
public class SameTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) {
            return true;
        }

        if((p == null && q != null) || (q == null && p != null)) {
            return false;
        }

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
