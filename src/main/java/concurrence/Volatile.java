/*
 * SPDX-License-Identifier: MIT
 * Inspired from https://github.com/thibaultdelor/InvalidCodeBlog
 * Substantially modified (structure and setup differ from the original).
 * Practical session: concurrency
 * Exercise: Java memory model
 */

package concurrence;

public class Volatile {

	// TODO : Invert comments on the next lines; What does "volatile" mean?
	//private int value = 0;
	private volatile int value = 0;

	public synchronized void increment() { 
		value++; 
	}
	
	public int get() { 
		return value; 
	}

	// TODO: prédire la sortie de ce programme
	public static void main(String[] args) throws InterruptedException {

		var counter = new Volatile();
		
		new Thread(() -> {
			while(counter.get()==0);
			System.out.println("done");
		}, "reader").start();

		Thread.sleep(250);

		new Thread(counter::increment, "writer").start();
		
	}
	
}

