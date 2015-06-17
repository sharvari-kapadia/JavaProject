package com.mindsmapped.hw1;

public class Q5ClassB extends Q5ClassA {
	public Q5ClassB() {
		System.out.println("ClassB constructor");
	}

	// public static void methodOne(int i) { }
	public void methodTwo(int i) {
	}

	// public void methodThree(int i) { }
	public static void methodFour(int i) {
	}
}

/*
 * methodTwo() in subclass ClassB OVERRIDES the one in super class ClassA
 * methodFour() in subclass ClassB HIDES the one in super class ClassA The
 * commented lines throw error because for over-riding the instance methods you
 * cannot change the signature.
 */
