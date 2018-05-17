package com.example.demo.algorithm;

public class AlgorithmUnionFindImprove {
    private int[] robbers;

    private int[] sizes;

    private int n;

    public AlgorithmUnionFindImprove(int n){
        this.n = n;
    }

    public void init(){
        robbers = new int[this.n];
        sizes = new int[this.n];

        for (int i =0; i<n; i++){
            robbers[i] = i;
            sizes[i] = 1;
        }
    }

    private int root(int i){
        while (i != robbers[i]){
            robbers[i] = robbers[robbers[i]];
            i = robbers[i];
        }
        return i;
    }

    public boolean find(int a, int b){
        if (root(a) == root(b)){
            return true;
        }
        return false;
    }

    public void union(int a, int b){
        int i = root(a);
        int j = root(b);
        if (sizes[i] < sizes[j]){
            robbers[i] = j;
            sizes[j] +=  sizes[i];
        } else {
            robbers[j] = i;
            sizes[i] += sizes[j];
        }
    }

    public static void main(String[] args) {
        AlgorithmUnionFindImprove algorithmUnionFindImprove = new AlgorithmUnionFindImprove(10);
        algorithmUnionFindImprove.init();
        algorithmUnionFindImprove.union(3, 4);
        algorithmUnionFindImprove.union(5, 4);
        algorithmUnionFindImprove.union(8, 9);
        algorithmUnionFindImprove.union(6, 7);
        algorithmUnionFindImprove.union(5, 8);
        System.out.println(algorithmUnionFindImprove.find(4, 5));
    }
}
