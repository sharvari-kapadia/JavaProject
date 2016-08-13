package com.leetcode.easy;

/**
 * Created by SKapadia on 6/16/2016.
 * https://leetcode.com/problems/add-digits/
 */
public class AddDigits {

    public int addDigits(int num) {

        while(num >= 10) {
            num = getSum(num);
        }
        return num;
    }

    private int getSum(int num) {

        int sum = 0;
        int temp = num;
        while(temp != 0) {
            sum += temp % 10;
            temp = temp / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(9999));
    }
}
