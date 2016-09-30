package com.leetcode.easy;

/**
 * Created by skapadia on 9/29/2016.
 * https://leetcode.com/problems/string-to-integer-atoi/
 * My understanding of the requirements:
 * 1. First character has to be + or - or a numeric. If not, return 0.
 * 2. Once you encounter a non-numeric character, your number ends there. Ignore all characters after that.
 * 3. Remove trailing spaces.
 */
public class StringToInteger {

    public int myAtoi(String str) {

        str = str.trim();
        int curr;
        int index;
        int result;
        boolean isPositive;

        if(str.length() > 0) {
            curr = (int)str.charAt(0);
            if(curr == '-') {
                isPositive = false;
                index = 1;
            } else if(curr == '+') {
                isPositive = true;
                index = 1;
            } else if(isNumeric(curr)) {
                isPositive = true;
                index = 0;
            } else {
                return 0;
            }
        } else {
            return 0;
        }

        if(index == 1 && str.length() == 1) {
            return 0;
        }

        curr = (int)str.charAt(index);
        if(isNumeric(curr)) {
            result = curr - 48;
        } else {
            return 0;
        }

        for(int i = index + 1; i < str.length(); i++) {
            curr = (int)str.charAt(i);
            if(isNumeric(curr)) {
                long newResult = ((long)result * 10) + curr - 48;
                if(newResult > Integer.MAX_VALUE) {
                    if(isPositive) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                result = (result * 10) + curr - 48;
            } else {
                break;
            }
        }
        if(!isPositive) {
            return (-1) * result;
        }
        return result;
    }

    private boolean isNumeric(int currChar) {
        return currChar >= 48 && currChar <= 57;
    }

    public static void main(String[] args) {
        StringToInteger object = new StringToInteger();

        assert 123 == object.myAtoi("+123");
        assert -123 == object.myAtoi("-123");
        assert -123 == object.myAtoi("-123 45");
        assert -123 == object.myAtoi("-123sdksdm");
        assert 0 == object.myAtoi("a-123sdksdm");
        assert 2147483647 == object.myAtoi("10522545459");
        assert 2147483647 == object.myAtoi("34843903489034803483410522545459");
        assert -2147483648 == object.myAtoi("-834734810522545459");
    }

}
