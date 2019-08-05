package com.leetcode.easy;

/**
 * Created by skapadia on 6/20/2016.
 * https://leetcode.com/problems/ugly-number/
 */
public class UglyNumber {

    public boolean isUgly(int num) {

        if(num == 0) {
            return false;
        }

        int[] primeNumbers = new int[]{2, 3, 5};
        for(int i = 0; i < primeNumbers.length; i++) {
            while(num % primeNumbers[i] == 0){
                num = num / primeNumbers[i];
            }
        }

        return num == 1;
    }

    public static void main(String[] args) {

        System.out.println(new UglyNumber().isUgly(5));
    }
}
