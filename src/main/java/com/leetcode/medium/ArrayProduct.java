package com.leetcode.medium;

import java.util.Arrays;

/**
 * Created by SKapadia on 7/26/2016.
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ArrayProduct {

    // O(n) space complexity solution
    public int[] productExceptSelf1(int[] nums) {

        int[] ans = new int[nums.length];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = 1;
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < ans.length; j++) {
                if(i == j) {
                    continue;
                }
                ans[j] = ans[j] * nums[i];
            }
        }
        return ans;
    }

    // Constance space complexity solution
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] ans = new int[length];
        int[] array1 = new int[length];
        int[] array2 = new int[length];

        int product1 = 1;
        int product2 = 1;

        for(int i = 0; i < length; i++) {
            product1 = product1*nums[i];
            array1[i] = product1;
            product2 = product2*nums[length - 1 - i];
            array2[length - 1 - i] = product2;
        }

        for(int i = 0; i < length; i ++) {
            ans[i] = (i - 1 < 0 ? 1 : array1[i-1]) * (i + 1 >= length ? 1 : array2[i+1]);
        }

        return ans;
    }


    public static void main(String[] args) {

        int[] ans = new ArrayProduct().productExceptSelf(new int[]{1, 2, 3 ,4});
        System.out.println(Arrays.toString(ans));

    }
}
