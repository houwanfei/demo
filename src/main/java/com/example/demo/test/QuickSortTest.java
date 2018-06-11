package com.example.demo.test;

import com.example.demo.algorithm.AlgorithmMergeSort;
import com.example.demo.algorithm.AlgorithmQuickSort;
import com.example.demo.algorithm.AlgorithmQuickSortParallel;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class QuickSortTest {
    public static void main(String[] args) {
        AlgorithmQuickSort quickSort = new AlgorithmQuickSort();
        Random random = new Random();
        int[] arrays = new int[8000000];
        int[] arrays1 = new int[8000000];
        int[] arrays2 = new int[8000000];
        for (int i =0; i<arrays.length; i++){
            arrays[i] = random.nextInt(1000);
            arrays1[i] = arrays[i];
            arrays2[i] = arrays[i];
        }
        long start1 = System.currentTimeMillis();
        AlgorithmQuickSort.arrays = arrays;
        quickSort.quickSort(0, arrays.length - 1);
        System.out.println((System.currentTimeMillis() - start1));

        ForkJoinPool pool = new ForkJoinPool();
        long start2 = System.currentTimeMillis();
        AlgorithmQuickSortParallel.arrays = arrays1;
        pool.submit(new AlgorithmQuickSortParallel(0, arrays1.length -1));
        pool.shutdown();
        try {
            pool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println((System.currentTimeMillis() - start2));

        AlgorithmMergeSort mergeSort = new AlgorithmMergeSort();
        int[] tmp = new int[arrays2.length];
        start1 = System.currentTimeMillis();
        mergeSort.sort(arrays2, 0, arrays2.length-1, tmp);
        System.out.println((System.currentTimeMillis() - start1));

        for (int i=0; i<arrays.length; i++){
            if (arrays[i] != arrays1[i] || arrays[i] != arrays2[i]){
                System.out.println("fuck");
            }
        }

    }
}
