package com.test.example;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        int numPermits = 2; // Number of permits available

        // Create a semaphore with 3 permits
        Semaphore semaphore = new Semaphore(numPermits);

        Runnable task = () -> {
            try {
                semaphore.acquire(); // Acquire a permit
                System.out.println(Thread.currentThread().getName() + " is accessing the resource.");
                Thread.sleep(2000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " has released the resource.");
                semaphore.release(); // Release the permit
            }
        };

        // Create and start multiple threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
