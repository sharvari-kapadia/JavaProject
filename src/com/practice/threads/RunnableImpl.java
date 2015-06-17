package com.practice.threads;

public class RunnableImpl implements Runnable {
	
	public int count;
	
	RunnableImpl() {
		count = 0;
	}
	
	@Override
	public void run() {
		synchronized(this) {
			for(int i = 0; i < 100000; i++) {
				count++;
			}
		}
	}
	
	public void printCount() {
		System.out.println(count);
	}
}
