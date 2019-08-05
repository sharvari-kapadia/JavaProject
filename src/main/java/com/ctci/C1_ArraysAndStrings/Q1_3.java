/*
 * 4.23.2015
 * Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string.
 */

package com.ctci.C1_ArraysAndStrings;

import java.util.Arrays;

public class Q1_3 {

    private String sort(String str) {

        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public boolean isString1PermutationOfString2(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        if (!sort(str1).equals(sort(str2))) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String[][] strings = {{"sharvi", "ivrahs"}, {"aakash", "aaassh"}};
        int stringsLen = strings.length;
        Q1_3[] q = new Q1_3[stringsLen];

        for (int i = 0; i < stringsLen; i++) {
            q[i] = new Q1_3();
            System.out.println(q[i].isString1PermutationOfString2(strings[i][0], strings[i][1]));
        }
    }
}
