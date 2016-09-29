package com.leetcode.easy;

/**
 * Created by skapadia on 9/28/2016.
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {

        StringBuffer sb = new StringBuffer();
        int mod = 0;
        while(n != 0) {
            mod = n % 26;
            mod = (mod == 0) ? mod + 26 : mod;
            sb.append((char)(mod + 64));
            n = n / 26;
        }
        return new String(sb.reverse());
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle object = new ExcelSheetColumnTitle();
        assert "A" == object.convertToTitle(1);
        assert "L" == object.convertToTitle(12);
        assert "T" == object.convertToTitle(20);
        assert "Z" == object.convertToTitle(26);
    }

}
