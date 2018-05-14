package com.example.demo;


import java.util.Random;
import java.util.concurrent.*;

/**
 * @auther houwanfei
 * @create 2017-12-18 下午12:32
 */
public class RecursiveActionTest extends RecursiveAction{
    private static final int THRES_HOLD = 500_000;
    static int[] arrays;
    int number;
    int start;
    int end;

    public RecursiveActionTest(int[] arrays, int number, int start, int end){
        this.arrays = arrays;
        this.number = number;
        this.start = start;
        this.end = end;
    }


    @Override
    protected void compute() {
        System.out.println("start:"+ start+ "end:"+end + "threshold:"+THRES_HOLD);
        if((end - start) < THRES_HOLD){
            computeMethod();
        }else {
            int mindle = (end + start)/2;
            RecursiveActionTest lTask = new RecursiveActionTest(arrays, number, start , mindle);
            RecursiveActionTest rTask = new RecursiveActionTest(arrays, number, mindle, end);
            invokeAll(lTask, rTask);
        }
    }

    private void computeMethod(){
        for (int i=start; i<end; i++){
            arrays[i] = arrays[i] * number;
        }
    }

    private static int[] randomArrays(int size){
        int[] arrays = new int[size];
        Random random = new Random();
        for (int i=0; i<size ;i++){
            arrays[i] = random.nextInt(100);
        }
        return arrays;
    }

    public static void main(String[] args) {
        int size = 100_000_000;
        int[] arrays = randomArrays(size);
        for (int i=0; i<10; i++){
            System.out.print(arrays[i] + "\t");
        }
        RecursiveActionTest task = new RecursiveActionTest(arrays, 10, 0, size);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        for (int i=0; i<10; i++){
            System.out.print(arrays[i] + "\t");
        }
    }
}
