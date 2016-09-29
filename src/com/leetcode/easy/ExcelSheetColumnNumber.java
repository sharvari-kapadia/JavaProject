package com.leetcode.easy;

/**
 * Created by SKapadia on 9/27/2016.
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {

        s = s.toUpperCase();
        int curr;
        int result = 0;
        for(int i = s.length() - 1; i >= 0; i--) {

            curr = s.charAt(i) - 64;
            result += curr * Math.pow(26, s.length() - i - 1);
        }

        return result;
    }

    public static void main(String[] args) {

        ExcelSheetColumnNumber object = new ExcelSheetColumnNumber();
        assert 1 == object.titleToNumber("A");
        assert 12 == object.titleToNumber("L");
        assert 20 == object.titleToNumber("T");
        assert 26 == object.titleToNumber("Z");

        assert (1+26) == object.titleToNumber("AA");
        assert (12+26) == object.titleToNumber("AL");
        assert (20+26) == object.titleToNumber("AT");
        assert (26+26) == object.titleToNumber("AZ");
    }
}
