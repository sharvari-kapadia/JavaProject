package com.leetcode.easy;

/**
 * Created by SKapadia on 9/12/2016.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        int length = nums.length;
        if(length == 0 || length == 1) {
            return length;
        }

        int i1 = 0;
        int i2 = 1;
        while(i2 < length) {

            if(nums[i1] == nums[i2]) {
                i2++;
            } else {
                nums[i1+1] = nums[i2];
                i1++;
                i2++;
            }
        }
        return i1+1;
    }

    public void printPartialArray(int[] nums, int newLength) {

        System.out.println();
        for(int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedArray object = new RemoveDuplicatesFromSortedArray();

        int[] array1 = new int[]{1,1,1,2,2,3,4,4};
        object.printPartialArray(array1, object.removeDuplicates(array1));

        int[] array2 = new int[]{1,2,3,4};
        object.printPartialArray(array2, object.removeDuplicates(array2));

        int[] array3 = new int[]{1,1,1};
        object.printPartialArray(array3, object.removeDuplicates(array3));

        int[] array4 = new int[]{};
        object.printPartialArray(array4, object.removeDuplicates(array4));
    }
}
