package com.leetcode.medium;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by SKapadia on 8/28/2016.
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleArray {

    Random rand;
    int[] returnArray;
    int[] nums;

    public ShuffleArray(int[] nums) {

        this.nums = nums;
        returnArray = new int[nums.length];
        rand = new Random();
    }

    public int[] reset() {

        return nums;
    }

    public int[] shuffle() {

        int[] tempNums = new int[nums.length];
        int length = nums.length;
        int index;
        int n = length;

        // Copy original array in tempNums which will be altered
        for(int i = 0; i < length; i++) {
            tempNums[i] = nums[i];
        }

        // Populate returnArray (No changes to be done to nums array as it needs to be saved for reset() API)
        for(int i = 0; i < length; i++) {

            index = rand.nextInt(n);
            returnArray[i] = tempNums[index];
            tempNums[index] = tempNums[n - 1];
            tempNums[n - 1] = -1;
            n--;
        }

        return returnArray;
    }

    public static void main(String[] args) {

        ShuffleArray obj = new ShuffleArray(new int[]{-1, 2});
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
    }
}
