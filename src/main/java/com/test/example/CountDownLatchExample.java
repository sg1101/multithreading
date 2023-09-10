package com.test.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CountDownLatchExample {
    public static void main(String[] args) {
        int numberOfThreads = 3;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        Runnable task = () -> {
            System.out.println("Thread is working...");
            latch.countDown(); // Signal that the thread has completed its work
        };

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(task).start();
        }

        try {
            latch.await(); // Wait for all threads to complete
            System.out.println("All threads have completed their work.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CountDownLatchExample.CyclicBarrierExample();
    }

    public static void CyclicBarrierExample() {
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads);

        Runnable task = () -> {
            System.out.println("Thread is ready");
            try {
                barrier.await(); // Wait for all threads to reach this point
                System.out.println("First Barrier passed");
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Thread continues...");
        };

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(task).start();
        }
    }
}
