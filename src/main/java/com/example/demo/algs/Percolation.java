package com.example.demo.algs;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    boolean[] openSite;
    WeightedQuickUnionUF uf;
    int top;
    int bottom;
    int N;

    public Percolation(int n){
        this.N = n;
        this.uf = new WeightedQuickUnionUF(n*n + 2);
        this.top = 0;
        this.bottom = n*n +1;
        openSite = new boolean[n*n + 2];
        for (int i = 1; i<=n*n; i++){
            openSite[i] = false;
        }
    }
    public void open(int row, int col){
        validate(row, col);
        int index = countIndex(row, col);
        if (row < N && openSite[index + N]){
            uf.union(index, index + N);
        }

        if (row > 1 && openSite[index - N]){
            uf.union(index, index - N);
        }

        if (col < N && openSite[index + 1]){
            uf.union(index, index + 1);
        }

        if (col > 1 && openSite[index - 1]){
            uf.union(index, index - 1);
        }
    }
    public boolean isOpen(int row, int col){
        validate(row, col);
        return openSite[countIndex(row, col)];
    }
    public boolean isFull(int row, int col){
        return uf.connected(top, countIndex(row, col));
    }

    public boolean percolates(){
        return uf.connected(top, bottom);
    }

    public int countIndex(int row, int col){
        validate(row, col);
        return N * (row -1) + col;
    }

    public void validate(int row, int col){
        if (row < 1 || row > N || col < 1 || col >N){
            throw new IndexOutOfBoundsException();
        }
    }
    public static void main(String[] args){

    }
}
