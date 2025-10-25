/*
 * SPDX-License-Identifier: MIT
 * Practical session: concurrency
 * Exercise: Asynchrony
 */

package concurrence;


public class HelloWorld {
	
	/*
	 * TODO: Use the debugger to display the following outputs.
	 * 
	 * Output 1:
	 * Hello Multithreaded World !
	 *
	 * Output 2:
	 * Hello World Multithreaded !
	 * 
	 * Is it possible to obtain the exclamation mark on the first line?
	 */
	public static void main( String args[] ) throws InterruptedException {

		var t1 = new Thread(() -> {
			System.out.print("Hello ");
			System.out.print("World ");
		}, "t1");
		
		var t2 = new Thread(() -> {
			System.out.print("Multithreaded ");
		}, "t2");

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println( "!" );
	}

}
