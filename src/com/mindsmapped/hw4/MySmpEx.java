package com.mindsmapped.hw4;

import java.util.ArrayList;
 
public class MySmpEx {
    public static int myCount = 0;
    
    public static <T, E> E genericMethod(T first, E second) {   	
    	System.out.println(first instanceof Integer);
    	return second;
    }
    
    public static void main(String args[]) {
    	System.out.println(MySmpEx.genericMethod("Sharvari", 5));
    }
}
