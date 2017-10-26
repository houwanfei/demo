package com.example.demo.algorithm;

/**
 * Created by houwanfei on 2017/10/15.
 */
public class AlgorithmTrie {
    private static final int MAX_NODE = 26;
    private TrieTreeNode root = new TrieTreeNode();
    int depth;

    class TrieTreeNode{
        char key;
        int isWord;
        int wordCount;
        int prefixCount;
        TrieTreeNode[] nodes;

        public TrieTreeNode(){
            this.isWord = 0;
            this.wordCount = 0;
            this.prefixCount = 0;
            this.nodes = new TrieTreeNode[MAX_NODE];
            for (int i=0; i<MAX_NODE; i++){
                this.nodes[i] = null;
            }
        }
    }

    /**
     * 向字典树中添加一个词
     * @param word
     */
    public void addWord(String word){
        addWord(this.root, word);
    }

    private boolean addWord(TrieTreeNode node, String word){
        int len = word.length();
        if(len == 0){
            return false;
        }

        char[] cWords = word.toCharArray();
        int i = 0;
        while (i < len){
            char c = cWords[0];
            c = Character.toLowerCase(c);
            int index = c - 'a';
            if(node.nodes[index] == null){
                node.nodes[index] = new TrieTreeNode();
                node.nodes[index].key = c;
                node.nodes[index].prefixCount = 1;
            } else {
                node.nodes[index].prefixCount++;
            }
            node = node.nodes[index];
            i++;
        }
        node.isWord = 1;
        node.wordCount++;
        if (len > this.depth){
            this.depth = len;
        }
        return true;

    }

    public TrieTreeNode findWord(String word){
        return findWord(root, word);
    }

    private TrieTreeNode findWord(TrieTreeNode node, String word){
        int len = word.length();
        if (len == 0){
            return null;
        }

        char[] cWords = word.toCharArray();
        int i = 0;
        while(i < len){
            char c = cWords[i];
            c = Character.toLowerCase(c);
            int index = c - 'a';
            if (node.nodes[index] == null){
                return null;
            } else {
                node = node.nodes[index];
            }
        }
        return node;
    }

    public static void main(String[] args){

    }
}
