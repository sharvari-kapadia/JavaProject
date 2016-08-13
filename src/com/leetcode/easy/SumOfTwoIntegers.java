package com.leetcode.easy;

/**
 * Created by skapadia on 7/6/2016.
 * https://leetcode.com/problems/sum-of-two-integers/
 */
public class SumOfTwoIntegers {

    private String appendZeros(String string, int numOfZeros) {

        StringBuffer temp = new StringBuffer("");
        for(int i  = 0; i < numOfZeros; i++) {
            temp.append("0");
        }

        return temp + string;
    }

    private boolean setCarry(int intNum1, int intNum2, int carry) {

        if(intNum1 == 1 && intNum2 == 1) {
            return true;
        }
        if(intNum1 == 1 && carry == 1) {
            return true;
        }
        if(intNum2 == 1 && carry == 1) {
            return true;
        }
        return false;
    }

    public int getSum(int num1, int num2) {

        String strNum1 = Integer.toBinaryString(num1);
        String strNum2 = Integer.toBinaryString(num2);

        int diff = strNum1.length() - strNum2.length();
        if(diff > 0) {
            strNum2 = appendZeros(strNum2, diff);
        } else if(diff < 0) {
            strNum1 = appendZeros(strNum1, -diff);
        }

        StringBuffer answer = new StringBuffer("");
        int intNum1;
        int intNum2;
        int xor;
        int carry = 0;

        for(int i = strNum1.length() -1; i >= 0; i--) {
            intNum1 = Character.getNumericValue(strNum1.charAt(i));
            intNum2 = Character.getNumericValue(strNum2.charAt(i));
            xor = intNum1 ^ intNum2 ^ carry;
            if(setCarry(intNum1, intNum2, carry)) {
                carry = 1;
            } else {
                carry = 0;
            }
            answer.append(xor);
        }

        if(carry == 1) {
            answer.append("1");
        }

        answer = answer.reverse();
        return Integer.parseInt(answer.toString(), 2);
    }

    public int getSum2(int a, int b) {

        if(a == 0) {
            return b;
        }
        if(b == 0) {
            return a;
        }
        int carry;
        while(b != 0) {
            carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {

        SumOfTwoIntegers object = new SumOfTwoIntegers();
        assert object.getSum(250, 450) == 700;
        assert object.getSum2(250, 450) == 700;
    }
}
