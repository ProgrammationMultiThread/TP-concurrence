/*
 * SPDX-License-Identifier: MIT
 * Practical session: concurrency
 * Exercise: Critical sections
 */

package concurrence;

import concurrence.utils.ParseArgs;

public class SharedCounter {

	private static int value = 0;

	// TODO : invert comments on next two lines
	// synchronized static void increment() {
	static void increment() {
		++value;
	}

	// TODO : invert comments on next two lines
	// synchronized static void decrement() {
	static void decrement() {
		--value;
	}	
	
	public static void main( String args[] ) throws InterruptedException {
		
		int iterations = ParseArgs.getInt(args, 0, "Number of iterations:", 10);

		Thread threads [] = new Thread[2];
		
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> { 
				for(int j = 0; j < iterations; j++) {
					increment();
					decrement();
				}
			});
		}
		
		for(Thread t : threads) t.start();
		for(Thread t : threads) t.join();

		// TODO: Predict the expected output
		// Explain the observation
		System.out.println("Value: " + value);
		
	}

}
