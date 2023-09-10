package com.test.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public void callThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i =1; i<=10; i++) {
            executorService.submit(() -> {
                LockExample.main();
                WaitNotify.main();
            });
        }
        executorService.shutdown();
    }
}
