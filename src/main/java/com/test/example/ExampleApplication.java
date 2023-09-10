package com.test.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ExampleApplication.class, args);
		Runnable thread1 = new Runnable() {
            @Override
            public void run() {
				System.out.println("thread1 is running");
            }
        };
		Thread thread3 = new Thread(thread1);
		thread3.start();
		Runnable thread2 = new Thread() {
			@Override
			public void run() {
				System.out.println("thread2 is running");
			}
		};
		Thread thread4 = new Thread(thread2);
		thread4.start();
		ThreadPoolExample threadPool = new ThreadPoolExample();
		threadPool.callThreadPool();
		DeadLockExample.main();
	}
}
