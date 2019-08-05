/*
 * 4.22.2015
 * Given two strings, write a method to  decide if one is a permutation of the other.
 */

package com.ctci.C1_ArraysAndStrings;

public class Q1_2 {

    public String reverse(String str) {

        int strLen = str.length();
        char[] charArray = str.toCharArray();
        char temp;

        for (int i = 0; i < strLen / 2; i++) {
            temp = charArray[i];
            charArray[i] = charArray[strLen - i - 1];
            charArray[strLen - i - 1] = temp;
        }
        return new String(charArray);
    }

    public static void main(String args[]) {

        String[] strings = {"sharvari", "aakash"};
        int stringsLen = strings.length;
        Q1_2[] q = new Q1_2[stringsLen];

        for (int i = 0; i < stringsLen; i++) {
            q[i] = new Q1_2();

            System.out.println("Original string: " + strings[i]);
            System.out.println("Reversed string: " + q[i].reverse(strings[i]));
            System.out.println();
        }
    }
}
