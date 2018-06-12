package com.example.demo.algorithm;

public class AlgorithmMergeSort {

    public void sort(int[] a, int low, int high, int[] tmp){
        if (low >= high){
            return;
        }
        int mid = (low + high) / 2;
        sort(a, low, mid, tmp);
        sort(a, mid+1, high, tmp);
        merge(a, low, mid, high, tmp);
    }

    public void merge(int[] a, int low, int mid,  int high, int[] tmp){
        int i = low;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= high){
            if (a[i] > a[j]){
                tmp[index++] = a[j++];
            } else {
                tmp[index++] = a[i++];
            }
        }
        while (i <= mid){
            tmp[index++] = a[i++];
        }
        while (j <= high){
            tmp[index++] = a[j++];
        }

        for (i = low, index = 0; i <= high; i++,index++){
            a[i] = tmp[index];
        }
    }

    public static void main(String[] args) {
        AlgorithmMergeSort mergeSort = new AlgorithmMergeSort();
        int[] a = {2, 3, 1, 9,8,6,5,4};
        int[] tmp = new int[a.length];
        mergeSort.sort(a, 0, a.length-1, tmp);
        for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
