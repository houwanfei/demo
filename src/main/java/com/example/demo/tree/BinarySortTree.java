package com.example.demo.tree;

/**
 * @auther houwanfei
 * @create 2018-06-07 下午3:06
 */
public class BinarySortTree {
    TreeNode root;

    public void insert(int key){
        TreeNode keyNode = new TreeNode();
        keyNode.setKey(key);
        keyNode.setLeft(null);
        keyNode.setRight(null);

        if (root == null){
            root = keyNode;
            return;
        }

        TreeNode node = root;
        TreeNode tmpNode = node;
        while (node != null){
            tmpNode = node;
            node = key < node.getKey() ? node.getLeft() : node.getRight();
        }

        if (key < keyNode.getKey())
            tmpNode.setLeft(keyNode);
        else
            tmpNode.setRight(keyNode);
    }

    public TreeNode search(int key){
        TreeNode node = root;
        while (node != null){
            if (node.getKey() == key)
                return node;
            node = key < node.getKey() ? node.getLeft() : node.getRight();
        }
        return null;
    }


    private TreeNode minNode(TreeNode node){
        TreeNode tmp = node;
        while (node != null){
            tmp = node;
            node = node.getLeft();
        }
        return tmp;
    }

    public static void main(String[] args) {
        BinarySortTree sortTree = new BinarySortTree();
        for (int i=0; i< 10; i ++){
            sortTree.insert(i);
        }

        TreeNode node = sortTree.search(8);

        TreeNode min = sortTree.minNode(node);
        System.out.println("ok");

    }
}

class TreeNode{
    private int key;

    private TreeNode left;

    private TreeNode right;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
