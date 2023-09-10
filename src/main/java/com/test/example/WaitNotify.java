package com.test.example;

public class WaitNotify {
    public static void main() {
        final Object lock = new Object();

        Thread producer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Producer thread is producing...");
                try {
                    Thread.sleep(2000); // Simulate some work.
                    System.out.println("Producer has produced successfully.");
                    lock.notify(); // Notify the waiting consumer thread.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Consumer thread is waiting...");
//                try {
//                    lock.wait(); // Wait for the producer to notify.
//                    System.out.println("Consumer has consumed successfully.");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("Consumer has consumed successfully.");
                System.out.println("Consumer thread is processing...");
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
