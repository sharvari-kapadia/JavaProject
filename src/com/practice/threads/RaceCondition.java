package com.practice.threads;

public class RaceCondition {
	
	public static void main(String[] args) throws InterruptedException {
		Runnable r = new RunnableImpl();
		Thread[] t = new Thread[10];
		
		for (int i = 0; i < 10; i++) {
			t[i] = new Thread(r);
			t[i].start();
		}
		
		for (int i = 0; i < 10; i++) {
			//t[i].join();
		}
		
		((RunnableImpl) r).printCount();	
	}
}
