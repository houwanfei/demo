package com.example.demo.algorithm;

/**
 * Created by houwanfei on 2017/10/14.
 */
public class AlgorithmUnionFind {

    public static int find(int[] robbers, int x){
        if(robbers[x] == x){
            return x;
        } else {
            robbers[x] = find(robbers, robbers[x]);
            return robbers[x];
        }
    }

    public static void init(int[] robbers){
        for (int i=0; i<robbers.length; i++){
            robbers[i] = i;
        }
    }

    public static void union(int[] robbers, int a, int b){
        int aRoot = find(robbers, a);
        int bRoot = find(robbers, b);

        if (aRoot != bRoot){
            robbers[aRoot] = bRoot;
        }
    }

    public static void main(String[] args){
        //int[] robbers = new int[]{0, 1, 2, 1, 3};
        int[] robbers = new int[11];

        init(robbers);
        union(robbers, 1, 4);
        union(robbers, 0, 5);
        union(robbers, 8, 9);
        union(robbers, 5, 9);

        for (int i=0; i<robbers.length; i++){
            find(robbers, i);
        }

        System.out.println(find(robbers, 4));

        for (int i=0; i<robbers.length; i++){
            System.out.print(robbers[i]+" ");
        }
    }
}
