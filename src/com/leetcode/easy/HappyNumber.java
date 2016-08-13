package com.leetcode.easy;

import java.util.HashSet;

/**
 * Created by SKapadia on 6/20/2016.
 * https://leetcode.com/problems/happy-number/
 */

public class HappyNumber {

    public boolean isHappy(int n) {

        int sumOfSquaresOfDigits;
        int tempNum = n;
        HashSet<Integer> set = new HashSet<>();
        do {
            sumOfSquaresOfDigits = getSumOfSquaresOfDigits(tempNum);
            if(sumOfSquaresOfDigits == 1) {
                return true;
            } else if(set.contains(sumOfSquaresOfDigits)) {
                return false;
            } else {
                set.add(sumOfSquaresOfDigits);
                tempNum = sumOfSquaresOfDigits;
            }

        } while(true);
    }

    private int getSumOfSquaresOfDigits(int num) {

        int sum = 0;
        int tempNum = num;
        while(tempNum > 0) {

            sum += Math.pow(tempNum % 10, 2);
            tempNum = tempNum / 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(new HappyNumber().isHappy(19)); //Happy
        System.out.println(new HappyNumber().isHappy(23)); //Happy
        System.out.println(new HappyNumber().isHappy(17)); //Not Happy

    }
}
