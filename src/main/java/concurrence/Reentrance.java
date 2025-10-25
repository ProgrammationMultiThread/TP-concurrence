/*
 * SPDX-License-Identifier: MIT
 * Practical session: concurrency
 * Exercise: Reentrance
 */

package concurrence;

import java.util.concurrent.locks.*;

public class Reentrance {

	// TODO : Invert comments on the next lines; What does "reentrant" mean?
	//private static Lock lock = new concurrence.utils.NonReentrantLock();
	private static Lock lock = new ReentrantLock();

	public static int factorial (int n) {
		lock.lock();
		try {
			if(n == 0) return 1;
			else return factorial(n-1)*n;
		} finally {
			lock.unlock();
		}
	}

	public static void main( String[] args ) {
		System.out.println(factorial(5));
	}

}
