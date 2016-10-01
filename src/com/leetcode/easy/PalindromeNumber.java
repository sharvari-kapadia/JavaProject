package com.leetcode.easy;

/**
 * Created by SKapadia on 9/30/2016.
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {

        if(x < 0) {
            return false;
        }

        int length = 0;
        int n = x;
        while(n != 0) {
            n = n / 10;
            length++;
        }

        // reset n to determine num1 (first half)
        n = x;
        int num1 = n / (int)(Math.pow(10, length/2));

        // for odd number of digits, ignore the middle digit
        if(length % 2 != 0) {
            num1 = num1 / 10;
        }

        // reset n to determine num2 (second half)
        n = x;
        int num2 = 0;
        for(int i = 0; i < length/2; i++) {
            num2 = (num2 * 10) + (n % 10);
            n = n/10;
        }

        return num1 == num2;
    }

    public static void main(String[] args) {

        PalindromeNumber object = new PalindromeNumber();
        object.isPalindrome(123321);
    }
}
