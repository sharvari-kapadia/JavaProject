package com.leetcode.easy;

/**
 * Created by SKapadia on 6/27/2016.
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeros {
    public static void moveZeroes(int[] input) {

        int zero = 0;
        int nonZero = 0;
        int temp;

        while(!isIndexOutOfBounds(zero, input) && !isIndexOutOfBounds(nonZero, input)) {

            while(input[zero] != 0) {
                zero++;
                if(isIndexOutOfBounds(zero, input)) {
                    return;
                }
            }

            while(input[nonZero] == 0) {
                nonZero++;
                if(isIndexOutOfBounds(nonZero, input)) {
                    return;
                }
            }

            if(nonZero > zero) {
                temp = input[zero];
                input[zero] = input[nonZero];
                input[nonZero] = temp;
            }
            nonZero++;
        }
    }

    private static boolean isIndexOutOfBounds(int index, int[] input) {
        return index < 0 || index >= input.length;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 0, 3, 12};
        int[] expectedResult = new int[]{1, 3, 12, 0, 0};
        MoveZeros.moveZeroes(input);

        for(int i = 0; i < input.length; i++) {
            assert input[i] == expectedResult[i];
        }
    }
}
