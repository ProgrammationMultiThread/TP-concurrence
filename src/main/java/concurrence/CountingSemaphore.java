/*
 * SPDX-License-Identifier: MIT
 * Inspired from https://www.mkyong.com/java/java-thread-mutex-and-semaphore-example/
 * Substantially modified (structure and setup differ from the original).
 * Practical session: concurrency
 * Exercise: Monitors
 */

package concurrence;

import concurrence.utils.ParseArgs;

public class CountingSemaphore {

	private int counter;

	public CountingSemaphore( int counter ) { 
		this.counter = counter; 
	}

	public synchronized void acquire() throws InterruptedException {
		while( counter <= 0 ) wait(); // When no tokens are free, the thread is put on hold.
		--counter; // Token consumption
	}

	public synchronized void release() {
		++counter; // The thread releases its token
		notify();
	}


	public static void main(String[] args) {
		// Create a semaphore
		int permits = ParseArgs.getInt(args, 0, "Number of permits:", 6);
		CountingSemaphore semaphore = new CountingSemaphore(permits);

		// Start 6 threads
		for(int i = 0; i < 6; i++){
			new Thread(() -> {
				try {
					String name = Thread.currentThread().getName();
					for( int j = 0 ; j < 5 ; ++j ) {
						System.out.println(name + " acquiring token...");
						semaphore.acquire();
						try {
							System.out.println(name + " is performing operation " + j);
							Thread.sleep(1000);
						} catch(InterruptedException e) {
							Thread.currentThread().interrupt();
						} finally {
							System.out.println(name + " releasing token...");
							semaphore.release();
						}
					}
				} catch(InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}, "Thread " + i).start();
		}
	}

}
