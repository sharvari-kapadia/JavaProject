package com.leetcode.easy;

/**
 * Created by SKapadia on 8/28/2016.
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {

        sum = new int[nums.length];

        if(nums.length > 0) {
            sum[0] = nums[0];
        }

        for(int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {

        if(i >= sum.length || j >= sum.length) {
            return 0;
        }

        if(i == 0) {
            return sum[j];
        } else {
            return sum[j] - sum[i-1];
        }
    }

    public static void main(String[] args) {

        NumArray obj1 = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assert  1 == obj1.sumRange(0, 2);
        assert -1 == obj1.sumRange(2, 5);
        assert -3 == obj1.sumRange(0, 5);

        NumArray obj2 = new NumArray(new int[]{-2, 1});
        assert -1 == obj2.sumRange(0, 1);
        assert -2 == obj2.sumRange(0, 0);
    }
}
