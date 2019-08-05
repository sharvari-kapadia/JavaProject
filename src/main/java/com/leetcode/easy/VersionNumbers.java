package com.leetcode.easy;

/**
 * Created by SKapadia on 6/28/2016.
 * https://leetcode.com/problems/compare-version-numbers/
 * Test cases on leetcode has some problem so the submission wasn't accepted.
 */
public class VersionNumbers {

    public int compareVersion(String version1, String version2) {

        String[] version1String = version1.split("\\.");
        String[] version2String = version2.split("\\.");
        int length1 = version1String.length;
        int length2 = version2String.length;
        int length = length1 >= length2 ? length1 : length2;
        String str1;
        String str2;

        for(int i = 0; i < length; i++) {
            if(i < length1) {
                str1 = version1String[i];
            } else {
                str1 = "0";
            }

            if(i < length2) {
                str2 = version2String[i];
            } else {
                str2 = "0";
            }

            int diff = str1.length() - str2.length();
            if(diff > 0) {
                str2 = (i == 0) ? prependZeros(str2, diff) : appendZeros(str2, diff);
            } else if(diff < 0) {
                str1 = (i == 0) ? prependZeros(str1, -diff) : appendZeros(str1, -diff);
            }

            int retValue = compareString(str1, str2);
            if(retValue != 0) {
                return retValue;
            }
        }
        return 0;
    }

    private int compareString(String string1, String string2) {

        int int1;
        int int2;
        for(int i = 0; i < string1.length(); i++) {
            int1 = Integer.parseInt("" + string1.charAt(i));
            int2 = Integer.parseInt("" + string2.charAt(i));
            if(int1 > int2) {
                return 1;
            } else if(int1 < int2) {
                return -1;
            }
        }
        return 0;
    }

    private String appendZeros(String string, int numOfZeros) {

        StringBuilder sb = new StringBuilder(string);
        for(int i = 0; i < numOfZeros; i++) {

            sb.append("0");
        }
        return new String(sb);
    }

    private String prependZeros(String string, int numOfZeros) {

        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < numOfZeros; i++) {

            sb.append("0");
        }
        sb.append(string);
        return new String(sb);
    }

    public static void main(String[] args) {

        assert 1 == new VersionNumbers().compareVersion("1", "0");
        assert -1 == new VersionNumbers().compareVersion("1.1", "1.2");
        assert 1 == new VersionNumbers().compareVersion("13.37", "13.3");
        assert -1 == new VersionNumbers().compareVersion("0.000000000000000000000000000000000000000000000000000001", "0.1");
        assert 0 == new VersionNumbers().compareVersion("0.100000000000000000000000000000000000000000000000000000", "0.1");
        assert -1 == new VersionNumbers().compareVersion("", "23");
        assert 1 == new VersionNumbers().compareVersion("0.1", "0.0.1");
        assert -1 == new VersionNumbers().compareVersion("12.23", "23.12");
    }
}
