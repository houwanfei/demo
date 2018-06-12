package com.example.demo.algorithm;


public class AlgorithmQuickSort {
    public static int[] arrays = null;
    public void quickSort(int low, int high){
        if ( low >= high){
            return;
        }
        int i = low;
        int j = high;
        int index = arrays[low];
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
        quickSort(low, i-1);
        quickSort(i+1, high);
    }

    public static void main(String[] args) {
        /*AlgorithmQuickSort quickSort = new AlgorithmQuickSort();
        Random random = new Random();
        //int[] arrays = {2, 5, 6, 11, 1, 4, 6, 8};
        int[] arrays = new int[1000000];
        for (int i =0; i<arrays.length; i++){
            arrays[i] = random.nextInt(1000);
        }
        System.out.println(System.currentTimeMillis());
        quickSort.quickSort(arrays, 0, arrays.length - 1);
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i<arrays.length; i++){
            //System.out.print(arrays[i] + "\t");
        }*/
    }
}
