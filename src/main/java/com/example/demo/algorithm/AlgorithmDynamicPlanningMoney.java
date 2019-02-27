package com.example.demo.algorithm;

public class AlgorithmDynamicPlanningMoney {
    static int[] p = {2, 3, 5, 1, 4};
    public static void main(String[] args) {
        //money();
        System.out.println(wines(1, 0, 4));
    }

    public static void money(){
        int[] a = {1, 3, 5};
        int sum = 13;
        int[] dp = new int[14];
        dp[0] = 0;
        for (int i=1; i<=13; i++){
            dp[i] = i;
        }

        for (int i=1; i<=13; i++){
            for (int j=0; j<3; j++){
                if (i >= a[j] && dp[i-a[j]] + 1 < dp[i]){
                    dp[i] = dp[i-a[j]] + 1;
                }
            }
        }

        for (int i=1; i<=13; i++){
            System.out.println("第"+ i +"money需要:" + dp[i]);
        }
    }

    public static int wines(int year, int be, int en){
        if (be > en)
            return 0;
        return Math.max(wines(year + 1, be+1, en) + year * p[be],
                wines(year + 1, be, en-1) + year * p[en]);
    }
}
