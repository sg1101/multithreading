package com.test.example;

public class LockExample {
    private static int classCounter = 0;
    private int instanceCounter = 0;

    // Class lock (static lock) example
    public static synchronized void incrementClassCounter() {
        // This method is synchronized on the class LockExample itself.
        classCounter++;
    }

    // Object lock (instance lock) example
    public synchronized void incrementInstanceCounter() {
        // This method is synchronized on the current instance of LockExample.
        instanceCounter++;
    }

    public static int getClassCounter() {
        return classCounter;
    }

    public int getInstanceCounter() {
        return instanceCounter;
    }

    public static void main() {
        LockExample obj1 = new LockExample();
        LockExample obj2 = new LockExample();

        // Creating threads to increment class counter
        Thread classLockThread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementClassCounter();
            }
        });

        Thread classLockThread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementClassCounter();
            }
        });

        // Creating threads to increment instance counter
        Thread instanceLockThread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                obj1.incrementInstanceCounter();
            }
        });

        Thread instanceLockThread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                obj2.incrementInstanceCounter();
            }
        });

        Thread instanceLockThread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                obj2.incrementInstanceCounter();
            }
        });
        instanceLockThread2.setDaemon(true);
        classLockThread1.start();
        classLockThread2.start();
        instanceLockThread1.start();
        instanceLockThread2.start();
        instanceLockThread3.start();

        try {
            classLockThread1.join();
            classLockThread2.join();
            instanceLockThread1.join();
            instanceLockThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Class Counter: " + getClassCounter());
        System.out.println("Instance Counter (Obj1): " + obj1.getInstanceCounter());
        System.out.println("Instance Counter (Obj2): " + obj2.getInstanceCounter());
    }
}
