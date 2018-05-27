package com.example.demo.algorithm;

public class AlgorithmPalindRome {
    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int n = 0;
        int m = x;
        while (m > 0){
            m = m / 10;
            n ++;
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = x % 10;
            x = x / 10;
        }
        for (int i=0, j=n-1; i< n/2; i++,j--){
            if (nums[i] != nums[j]){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x){
        int sum = 0;
        int old = x;
        while (x >0){
            sum = sum * 10 + x % 10;
            x = x / 10;
        }

        if (sum == old){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        isPalindrome(1234321);
        System.out.println(System.currentTimeMillis());
        isPalindrome2(1001);
        System.out.println(System.currentTimeMillis());
    }
}
