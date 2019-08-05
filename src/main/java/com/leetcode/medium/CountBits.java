package com.leetcode.medium;

import java.util.Arrays;

/**
 * Created by SKapadia on 7/20/2016.
 * https://leetcode.com/problems/counting-bits/
 */
public class CountBits {

    public int[] countBits(int num) {

        if(num < 0) {
            return new int[0];
        }
        int[] result = new int[num+1];
        result[0] = 0;
        if(num == 0) {
            return result;
        }
        result[1] = 1;
        for(int i = 2; i < num+1; i++) {
            result[i] = result[i/2] + result[i%2];
        }
        return result;
    }

    public static void main(String[] args) {

        CountBits object = new CountBits();
        int[] ans;
        for(int i = 0; i < 16; i++) {
            ans = object.countBits(i);
            System.out.println(i + ": " + Arrays.toString(ans));
        }
    }
}
