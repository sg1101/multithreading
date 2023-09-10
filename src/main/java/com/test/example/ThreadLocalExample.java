package com.test.example;

public class ThreadLocalExample {
    // Create a ThreadLocal variable to store an integer value.
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        // Create and start three threads.
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 1: ThreadLocal value = " + threadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2: ThreadLocal value = " + threadLocal.get());
        });

        Thread thread3 = new Thread(() -> {
            threadLocal.set(3);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 3: ThreadLocal value = " + threadLocal.get());
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
