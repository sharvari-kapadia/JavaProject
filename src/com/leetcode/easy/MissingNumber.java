package com.leetcode.easy;

/**
 * Created by SKapadia on 9/15/2016.
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n * (n + 1))/2;
        int actualSum = 0;
        int curr;
        for(int i = 0; i < n; i++) {
            curr = nums[i];
            actualSum += curr;
        }
        return sum - actualSum;
    }

    public static void main(String[] args) {
        MissingNumber object = new MissingNumber();
        assert 2 == object.missingNumber(new int[]{0, 1, 3});
        assert 1 == object.missingNumber(new int[]{0});
    }
}
