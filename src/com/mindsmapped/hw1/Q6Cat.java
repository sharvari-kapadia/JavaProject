package com.mindsmapped.hw1;


public class Q6Cat {
	public static void testClassMethod() {
		System.out.println("The static method in Cat");
	}

	public void testInstanceMethod() {
		System.out.println("The instance method in Cat");
	}
	
	public static void main(String[] args) {
		Q6Cat myCat = new Q6Cat();
		Q6Animal myAnimal = new Q6Animal();
		// Animal myAnimal = myCat; ---------------------Question??
		Q6Animal.testClassMethod(); // static method of super class
		Q6Cat.testClassMethod(); // static method of subclass
		myAnimal.testInstanceMethod(); // instance method of super class
		myCat.testInstanceMethod(); // instance method of subclass
	}
}
