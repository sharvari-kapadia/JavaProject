// 4.24.2015: Replace space with %20 in String
package com.practice.ctci.ArraysAndStrings;

public class Q1_4 {
    // Returns number of spaces in a string
    private int getNumberOfSpaces(String str) {

        int num = 0;
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (c == ' ') {
                num++;
            }
        }
        return num;
    }

    // Adds 2*numberOfSpaces extra spaces towards the end
    public String getStringWithSpacesAtEnd(String str) {

        int numberOfSpaces = getNumberOfSpaces(str);
        String spaceStr = "";
        for (int i = 0; i < numberOfSpaces; i++) {
            spaceStr += "  ";
        }
        return new String(str + spaceStr);
    }

    // METHOD 1 helper
    // Shift sub-string to right from currentChar to lastChar by 2.
    // Insert characters "%20".
    private void shiftStringAndInsertCharacters(char[] charArray, int currentCharPos, int lastCharPos) {

        for (int i = lastCharPos; i > currentCharPos; i--) {
            charArray[i + 2] = charArray[i];
        }

        charArray[currentCharPos] = '%';
        charArray[currentCharPos + 1] = '2';
        charArray[currentCharPos + 2] = '0';
    }

    // METHOD 1 - O(n^2)
    // Start from first character. When you hit ' ', move the rest of the
    // characters by 2 and replace ' ' by "%20"
    public String replaceSpaces1(String str, int trueLen) {

        char[] charArray = str.toCharArray();
        int strLen = str.length();
        int lastCharPos = trueLen - 1;

        for (int i = 0; i < strLen; i++) {
            if (charArray[i] == ' ') {
                shiftStringAndInsertCharacters(charArray, i, lastCharPos);
                // increment the current position and last character position by
                // two since two extra characters have been inserted in the
                // original char array
                lastCharPos += 2;
                i += 2;
            } else {
                continue;
            }
        }
        return new String(charArray);
    }

    // METHOD 2 - O(2*n)
    // Start from the last character of trueStr. Shift the characters by
    // 2*numOfSpaces and replace ' ' with "%20" in one go
    public String replaceSpaces2(String str, String trueStr, int trueLen) {

        int numOfSpaces = getNumberOfSpaces(trueStr);
        char[] charArray = str.toCharArray();
        boolean isCurrCharSpace = false;
        int newPos = 0;

        for (int i = trueLen - 1; i > 0; i--) {
            if (charArray[i] == ' ') {
                isCurrCharSpace = true;
            }
            newPos = i + (2 * numOfSpaces);
            charArray[newPos] = charArray[i];

            if (isCurrCharSpace) {
                charArray[newPos - 2] = '%';
                charArray[newPos - 1] = '2';
                charArray[newPos] = '0';

                numOfSpaces -= 1;
                isCurrCharSpace = false;
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        String[] strings = {"sharvari weds aakash", "Hello everyone, Good morning!"};
        int stringsLen = strings.length;
        Q1_4[] q = new Q1_4[stringsLen];

        for (int i = 0; i < stringsLen; i++) {
            q[i] = new Q1_4();

            System.out.println("Original string: " + strings[i]);
            String newStr = q[i].getStringWithSpacesAtEnd(strings[i]);
            System.out.println("Method1 - Replaced string: "
                    + q[i].replaceSpaces1(newStr, strings[i].length()));
            System.out.println("Method2 - Replaced string: "
                    + q[i].replaceSpaces2(newStr, strings[i],
                    strings[i].length()));
            System.out.println();
        }
    }
}
