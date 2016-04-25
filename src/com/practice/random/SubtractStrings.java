package com.practice.random;

/**
 * Created by SKapadia on 4/20/2016.
 */
public class SubtractStrings {

    public static String subtract(String one, String two) throws Exception {

        boolean secondGreaterThanFirst = false;
        StringBuffer answer = new StringBuffer();
        StringBuffer first = new StringBuffer(one);
        StringBuffer second = new StringBuffer(two);

        // check if both strings are valid i.e. they are numbers
        if(!isStringValid(first) || !isStringValid(second)) {
            throw new Exception("Enter valid strings.");
        }

        // When second is greater than first
        if(isSecondGreaterThanFirst(first, second)) {
            secondGreaterThanFirst = true;

            //swap the numbers
            StringBuffer temp = first;
            first = second;
            second = temp;
        }

        // When both strings are of different length
        int firstLength = first.length();
        int secondLength = second.length();
        int diff = firstLength - secondLength;
        if(diff > 0) {
            StringBuffer zeros = new StringBuffer();
            for(int i = 0; i < diff; i++) {
                zeros.append('0');
            }
            second = zeros.append(second);
        }

        char firstChar;
        char secondChar;
        int firstInt;
        int secondInt;
        int tempAns;

        for(int j = firstLength - 1; j >= 0; j--){

            firstChar = first.charAt(j);
            secondChar = second.charAt(j);
            firstInt = (int)firstChar;
            secondInt = (int)secondChar;

            if(firstInt >= secondInt) {
                tempAns = firstInt - secondInt;
            } else {
                tempAns = 10 + firstInt - secondInt;

                if(j > 0) {
                    first.setCharAt(j - 1, (char)((int)first.charAt(j - 1) - 1));
                }
            }

            answer.append(tempAns);
        }

        answer = answer.reverse();

        if(secondGreaterThanFirst) {
            return "-" + answer.toString();
        } else {
            return answer.toString();
        }
    }

    public static boolean isSecondGreaterThanFirst(StringBuffer first, StringBuffer second) {

        int firstLength = first.length();
        int secondLength = second.length();
        int lengthDiff = firstLength - secondLength;
        if(lengthDiff > 0) {
            return false;
        } else if(lengthDiff < 0) {
            return true;
        } else {

            for(int i = 0; i < firstLength; i++) {
                int diff = (int)first.charAt(i) - (int)second.charAt(i);
                if(diff > 0) {
                    return false;
                } else if (diff < 0) {
                    return true;
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    private static boolean isStringValid(StringBuffer string) {

        for(int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if(currentChar < 48 || currentChar > 57) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(SubtractStrings.subtract("222", "111"));
        System.out.println(SubtractStrings.subtract("222", "123"));
        System.out.println(SubtractStrings.subtract("3222", "333"));
    }
}
