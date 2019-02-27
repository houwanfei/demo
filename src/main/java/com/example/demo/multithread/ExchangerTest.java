package com.example.demo.multithread;

import java.util.concurrent.*;

public class ExchangerTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        final Exchanger<String> exchanger = new Exchanger<>();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("我A开始交换了");
                    String str = exchanger.exchange(Thread.currentThread().getName() + " A");
                    System.out.println("我A交换得到了： " + str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("我B开始交换了");
                    String str = exchanger.exchange(Thread.currentThread().getName() + " B");
                    System.out.println("我B交换得到了： " + str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
