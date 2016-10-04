package com.leetcode.easy;

/**
 * Created by SKapadia on 10/2/2016.
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {

    public void rotate1(int[] nums, int k) {

        int n = nums.length;
        int[] newArray = new int[n];
        for(int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        for(int i = 0; i < n; i++) {
            nums[i] = newArray[i];
        }
    }

    public void rotate2(int[] nums, int k) {

        int n = nums.length;
        int temp;
        for(int i = 0; i < k; i++) {
            temp = nums[n-1];
            for(int j = (n-1); j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        if(n == 0) {
            return;
        }
        k = k % n;
        int[] temp = new int[k];

        for(int i = n-k, j = 0; i < n; i++, j++) {
            temp[j] = nums[i];
        }

        for(int i = n-k-1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for(int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        RotateArray object = new RotateArray();

        int[] arr1 = new int[]{1,2,3,4,5,6,7};
        object.rotate(arr1, 3);
        int[] ans1 = new int[]{5,6,7,1,2,3,4};
        for(int i = 0; i < arr1.length; i++) {
            assert ans1[i] == arr1[i];
        }
    }
}
