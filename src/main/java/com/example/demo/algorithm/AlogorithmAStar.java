package com.example.demo.algorithm;

import java.util.Random;

/**
 * Created by houwanfei on 2017/10/15.
 */
public class AlogorithmAStar {
    private AStarNode[][] maps;
    private static final String WALL = "*";
    private static final String ROAD = "-";

    class AStarNode{
        int key;
        int fValue;
        int gValue;
        int hValue;
        boolean isVisit;
        AStarNode next;

        public AStarNode(int key){
            this.key = key;
            this.fValue = 0;
            this.gValue = 0;
            this.hValue = 0;
            this.isVisit = false;
            this.next = null;
        }
    }

    public void init(int n){
        this.maps = new AStarNode[n][n];
        Random random = new Random();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                int randomValue = random.nextInt(7)<5?0:1;
                this.maps[i][j] = new AStarNode(randomValue);
            }
        }
    }


    public void findShortestPath(int srcX, int srcY, int dstX, int dstY){

    }



    public static void main(String[] args){
        AlogorithmAStar aStar = new AlogorithmAStar();
        aStar.init(10);
        for (int i=0; i< 10; i++){
            for (int j=0; j<10; j++){
                if (aStar.maps[i][j].key == 0){
                    System.out.print(ROAD);
                }else{
                    System.out.print(WALL);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
