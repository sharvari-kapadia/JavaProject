package com.practice.hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: SKapadia
 * Date: 5/30/16
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Q2_2_StringSimilarity {

    static int[] StringSimilarity(String[] inputs) {

        int[] returnValue = new int[inputs.length];
        for(int i = 0; i < inputs.length; i++) {
            returnValue[i] = getSimilaritySum(inputs[i]);
        }
        return returnValue;
    }

    private static int getSimilaritySum(String string) {

        int sum = 0;
        for(int i = 0; i < string.length(); i++) {
            sum += getSimilarity(string, i);
        }
        return sum;
    }

    private static int getSimilarity(String string1, int startIndex) {

        int similarity = 0;
        for(int i = 0; i < string1.length() - startIndex; i++) {
            if(string1.charAt(i) == string1.charAt(startIndex + i)) {
                similarity++;
            } else {
                break;
            }
        }
        return similarity;
    }
}
