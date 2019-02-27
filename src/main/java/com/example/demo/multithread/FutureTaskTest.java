package com.example.demo.multithread;



import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("我先睡一会");
                Thread.sleep(5000);
                return 10;
            }
        });

        new Thread(futureTask).start();

        System.out.println("我是主线程");
        //Integer result = futureTask.get();
        //System.out.println(result);
        Thread.sleep(2000);
        futureTask.cancel(true);
    }
}
