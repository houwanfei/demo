package com.example.demo.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class AlgorithmACAutoman {
    private static final int MAX_NODE = 26;
    private ACNode root = new ACNode();

    class ACNode{
        char key;
        int isWord;
        int wordCount;
        ACNode failNode;
        ACNode[] nodes;

        public ACNode(){
            this.isWord = 0;
            this.wordCount = 0;
            failNode = null;
            nodes = new ACNode[MAX_NODE];
            for(int i =0; i<MAX_NODE; i++){
                nodes[i] = null;
            }
        }
    }

    public void buildTrieTree(String[] words){
        buildTrieTree(root, words);
    }

    public void buildTrieTree(ACNode node, String[] words){
        for (String word : words){
            buildTrieTree(node, word);
        }
    }
    public boolean buildTrieTree(ACNode node, String word){
        int len = word.length();
        if(len <= 0){
            return false;
        }

        char[] wordc = word.toCharArray();
        int i = 0;
        while (i < len){
            char c = wordc[i];
            int index = c - 'a';
            if(node.nodes[index] == null){
                node.nodes[index] = new ACNode();
                node.nodes[index].key = c;
            }

            node = node.nodes[index];
            i++;
        }

        node.wordCount++;
        node.isWord = 1;

        return true;
    }

    public void buildFailNode(ACNode root){
        root.failNode = null;
        Queue<ACNode> acQueue = new LinkedList<ACNode>();
        acQueue.add(root);
        while (!acQueue.isEmpty()){
           ACNode tmpNode =  acQueue.poll();
           ACNode parentFail = null;
           for(int i=0; i<MAX_NODE; i++){
               if (tmpNode.nodes[i] != null){
                   if (tmpNode == root){
                       tmpNode.nodes[i].failNode = root;
                   }else{
                       parentFail = tmpNode.failNode;
                       while (parentFail != null){
                           if(parentFail.nodes[i] != null){
                               tmpNode.nodes[i].failNode = parentFail.nodes[i];
                               break;
                           }
                           parentFail = parentFail.failNode;
                       }
                       if(parentFail == null){
                           tmpNode.nodes[i].failNode = root;
                       }

                   }
                   acQueue.add(tmpNode.nodes[i]);
               }
           }

        }
    }

    public int query(String str){
        int i = 0;
        int count = 0;
        int len = str.length();
        char[] cStr = str.toCharArray();
        ACNode node = root;
        while(i<len){
            int index = cStr[i] - 'a';
            while (node.nodes[index] == null && node != root){
                node = node.failNode;
            }
            node = node.nodes[index];
            node = (node == null)?root:node;
            ACNode tmp = node;
            while (tmp != root && tmp.isWord == 1){
                count++;
                tmp = tmp.failNode;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args){
        AlgorithmACAutoman automan = new AlgorithmACAutoman();
        String[] words = new String[]{"say","she","shr","he","her"};
        automan.buildTrieTree(words);
        automan.buildFailNode(automan.root);
        int count = automan.query("yasherhsay");
        System.out.println(count);
    }
}
