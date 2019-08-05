package com.practice;

import java.util.*;
/**
 * Created by skapadia on 4/8/2016.
 */
public class DelimiterCheck {

    private HashMap<Character, Character> delimiters;
    private String string;

    DelimiterCheck(String string) {

        delimiters = new HashMap<>();
        delimiters.put('[', ']');
        delimiters.put('{', '}');
        delimiters.put('(', ')');

        this.string = string;
    }

    public boolean areDelimitersMatched() {

        Stack<Character> stack = new Stack<Character>();
        char currentChar;

        for(int i = 0; i < string.length(); i++) {
            currentChar = string.charAt(i);
            if(isOpeningDelimiter(currentChar)) {
                stack.push(currentChar);
                continue;
            } else if(isClosingDelimiter(currentChar)) {
                if(currentChar == delimiters.get(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    private boolean isOpeningDelimiter(char delimiterChar) {

        if(delimiters.keySet().contains(new Character(delimiterChar))) {
            return true;
        }
        return false;
    }

    private boolean isClosingDelimiter(char delimiterChar) {

        if(delimiters.values().contains(new Character(delimiterChar))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String string = "[{(Sharvari)}]";
        DelimiterCheck delimiterCheck = new DelimiterCheck(string);
        System.out.println(string + " : " + delimiterCheck.areDelimitersMatched());
    }
}
