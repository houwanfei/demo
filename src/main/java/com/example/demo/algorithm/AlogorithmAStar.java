package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by houwanfei on 2017/10/15.
 */
public class AlogorithmAStar {
    private AStarNode[][] maps;
    private static final String WALL = "*";
    private static final String ROAD = "-";
    List<AStarNode> openList = new ArrayList<AStarNode>();
    List<AStarNode> closeList = new ArrayList<AStarNode>();

    class AStarNode{
        int x,y;
        int key;
        int fValue;
        int gValue;
        int hValue;
        boolean isVisit;
        AStarNode pre;

        public AStarNode(int x, int y,int key){
            this.x = x;
            this.y = y;
            this.key = key;
            this.fValue = 0;
            this.gValue = 0;
            this.hValue = 0;
            this.isVisit = false;
            this.pre = null;
        }
    }

    public void init(int n){
        this.maps = new AStarNode[n][n];
        Random random = new Random();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                int randomValue = random.nextInt(7)<5?0:1;
                this.maps[i][j] = new AStarNode(i, j, randomValue);
            }
        }
    }

    private AStarNode findMinFNode(){
        if(openList.size() <= 0){
            return null;
        }

        AStarNode minNode = openList.get(0);
        for (AStarNode node:openList){
            if(node.fValue < minNode.fValue){
                minNode = node;
            }
        }
        return minNode;
    }

    private List<AStarNode> findNeighbors(AStarNode currentNode){
        List<AStarNode> asNodeList = new ArrayList<AStarNode>();
        //top node
        if(checkBordor(currentNode.x-1,currentNode.y) && isContain(closeList, maps[currentNode.x-1][currentNode.y])){
            asNodeList.add(maps[currentNode.x-1][currentNode.y]);
        }
        //left node
        if(checkBordor(currentNode.x, currentNode.y-1) && isContain(closeList, maps[currentNode.x-1][currentNode.y])){
            asNodeList.add(maps[currentNode.x][currentNode.y-1]);
        }
        //bottom node
        if (checkBordor(currentNode.x+1, currentNode.y) && isContain(closeList, maps[currentNode.x-1][currentNode.y])){
            asNodeList.add(maps[currentNode.x+1][currentNode.y]);
        }
        //right node
        if (checkBordor(currentNode.x, currentNode.y+1) && isContain(closeList, maps[currentNode.x-1][currentNode.y])){
            asNodeList.add(maps[currentNode.x][currentNode.y+1]);
        }

        return asNodeList;
    }

    private boolean isContain(List<AStarNode> list, AStarNode node){
        for (AStarNode n:list){
            if(n.x == node.x && n.y == node.y){
                return true;
            }
        }
        return false;
    }

    private boolean checkBordor(int x, int y){
        if(x>=0 && x<maps.length && y>=0 && y<maps[0].length){
            return maps[x][y].key == 0 && !maps[x][y].isVisit;
        }
        return false;
    }

    private boolean notFoundInOpenList(AStarNode tempStart, AStarNode node, AStarNode endNode){
        node.pre = tempStart;
        node.gValue = countGValue(node);
        node.hValue = countHValue(node, endNode);
        node.fValue = node.gValue + node.hValue;
        openList.add(node);
        return true;
    }

    private boolean foundInOpenList(AStarNode node, AStarNode tempStart){
        int gValue = countGValue(node);
        if(gValue < node.gValue){
            node.gValue = gValue;
            node.pre = tempStart;
            node.fValue = node.gValue + node.hValue;
        }
        return true;
    }

    private int countGValue(AStarNode node){
        int preGValue = node.pre != null?node.pre.gValue:0;
        return preGValue+1;
    }

    private int countHValue(AStarNode node, AStarNode endNode){
        return Math.abs(endNode.x - node.x) + Math.abs(endNode.y - node.y);
    }


    public AStarNode findShortestPath(AStarNode startNode, AStarNode endNode){
        openList.add(startNode);

        while (openList.size() >0){
            AStarNode currentNode = findMinFNode();

            openList.remove(currentNode);

            closeList.add(currentNode);

            List<AStarNode> neighborList = findNeighbors(currentNode);

            for(AStarNode node:neighborList){
                if(isContain(openList, node)){//node is aready in openList
                    foundInOpenList(currentNode, node);
                } else {//node is not in openList
                    notFoundInOpenList(currentNode, node, endNode);
                }
            }

            if(find(openList, endNode) != null){
                return find(openList, endNode);
            }
        }
        return find(openList, endNode);
    }

    private AStarNode find(List<AStarNode> openList, AStarNode node){
        for(AStarNode n : openList){
            if(n.x == node.x && n.y == node.y){
                return n;
            }
        }
        return null;
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
