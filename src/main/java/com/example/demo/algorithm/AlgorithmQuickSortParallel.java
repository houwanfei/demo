package com.example.demo.algorithm;

import java.util.concurrent.RecursiveAction;

public class AlgorithmQuickSortParallel extends RecursiveAction{
    public static int[] arrays = null;
    int low;
    int high;
    public AlgorithmQuickSortParallel(int low, int high){
        this.low = low;
        this.high = high;
    }
    @Override
    protected void compute() {
        if (low >= high){
            return;
        }
        int mid = partion(arrays, low, high);
        new AlgorithmQuickSortParallel(low, mid-1).fork();
        new AlgorithmQuickSortParallel(mid+1, high).fork();
    }

    private int partion(int[] arrays, int low, int high){
        int index = arrays[low];
        int i = low;
        int j = high;

        while (i < j){
            while (i < j && arrays[j] >= index){
                j--;
            }
            if (i < j){
                arrays[i++] = arrays[j];
            }

            while (i < j && arrays[i] <= index){
                i++;
            }
            if (i < j){
                arrays[j--] = arrays[i];
            }
        }
        arrays[i] = index;
        return i;
    }
}
