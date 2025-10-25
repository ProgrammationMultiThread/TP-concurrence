/*
 * SPDX-License-Identifier: MIT
 * Author: Matthieu Perrin  
 */

package concurrence.utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * A simple, non-reentrant mutex implemented with the intrinsic monitor.
 * - Not reentrant: if the owning thread calls lock() again, it will block forever
 *   (since unlock() is never reached), which is the intended behavior for teaching reentrancy.
 * - Conditions are not supported.
 *
 * This class is intentionally minimal for educational purposes (no fairness).
 */
public class NonReentrantLock implements Lock {

    private boolean locked = false;

    @Override
    public synchronized void lock() {
        while (locked) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        locked = true;
    }

    @Override
    public synchronized void lockInterruptibly() throws InterruptedException {
        while (locked) {
            wait();
        }
        locked = true;
    }

    @Override
    public synchronized boolean tryLock() {
        if (locked) return false;
        locked = true;
        return true;
    }

    @Override
    public synchronized boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        long remainingNanos = unit.toNanos(time);
        long deadline = System.nanoTime() + remainingNanos;

        while (locked) {
            if (remainingNanos <= 0L) return false;
            long millis = remainingNanos / 1_000_000L;
            int nanos = (int) (remainingNanos % 1_000_000L);
            wait(millis, nanos);
            remainingNanos = deadline - System.nanoTime();
        }
        locked = true;
        return true;
    }

    @Override
    public synchronized void unlock() {
        if (!locked) throw new IllegalMonitorStateException("Not locked");
        locked = false;
        notifyAll();
    }

    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException("Conditions are not supported by NonReentrantLock");
    }	
}

