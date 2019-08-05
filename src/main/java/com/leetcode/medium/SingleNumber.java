/*
* Given an array of integers, every element appears twice except for one. Find that single one.
* Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
* */
package com.leetcode.medium;

/**
 * Created by SKapadia on 7/20/2016.
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int length = nums.length;
        int result = 0;
        for(int i = 0; i < length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        assert 1 == new SingleNumber().singleNumber(new int[]{1});
    }
}
