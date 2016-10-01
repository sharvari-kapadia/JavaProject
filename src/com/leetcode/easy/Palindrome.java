package com.leetcode.easy;

/**
 * Created by skapadia on 9/30/2016.
 * https://leetcode.com/problems/valid-palindrome/
 */
public class Palindrome {
    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {

            while(i < s.length() && !isAlphanumeric(s.charAt(i))) {
                i++;
            }

            while(j >= 0 && !isAlphanumeric(s.charAt(j))) {
                j--;
            }

            if(i >= s.length() || j >= s.length()) {
                return true;
            }

            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        boolean isNumeric = c >= 48 && c <= 57;
        boolean isAlphabet = c >= 65 && c <= 90;
        if(isNumeric || isAlphabet) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Palindrome object = new Palindrome();
        assert true == object.isPalindrome("A man, a plan, a canal: Panama");
        assert false == object.isPalindrome("race a car");
        assert true == object.isPalindrome("@#$$%$%");
        assert true == object.isPalindrome("   ");
    }
}
