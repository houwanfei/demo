package com.example.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @auther houwanfei
 * @create 2017-12-18 上午9:16
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THREAD_HOLDa = 2;
    private int start;

    private int end;

    public CountTask(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;
        if(end-start <= THREAD_HOLDa){
            for (int i=start;i<end;i++){
                sum = sum + i;
            }
        } else {
            int mindle = (start + end)/2;
            CountTask lTask = new CountTask(start , mindle);
            CountTask rTask = new CountTask(mindle, end);
            lTask.fork();
            rTask.fork();

            sum = lTask.join() + rTask.join();
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        CountTask task = new CountTask(1,1000);
        Future<Integer> result = pool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
