package com.example.demo.algorithm;

/**
 * @auther houwanfei
 * @create 2018-06-12 下午1:27
 */
public class AlgorithmRedBlackTree {
    public static final int BLACK = 0;
    public static final int RED = 1;
    public TreeNode root;
    class TreeNode{
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        public int color;

        public TreeNode(int key){
            this.color = RED;
            this.key = key;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    /**
     * 获取祖父节点
     * @param node
     * @return
     */
    private TreeNode grandfatherNode(TreeNode node){
        return node.parent.parent;
    }

    /**
     * 左旋
     * @param node
     */
    private void leftRotate(TreeNode node){
        TreeNode p = node.parent;
        TreeNode g = grandfatherNode(node);
        if (g != null) {
            if (p == g.left) {
                g.left = node;
            } else {
                g.right = node;
            }
        } else {
            this.root = node;
        }
        node.parent = g;
        p.right = node.left;
        node.left = p;
        p.parent = node;
    }

    /**
     * 右旋
     * @param node
     */
    private void rightRotate(TreeNode node){
        TreeNode p = node.parent;
        TreeNode g = grandfatherNode(node);

        if (g != null) {
            if (p == g.left) {
                g.left = node;
            } else {
                g.right = node;
            }
        } else{
            this.root = node;
        }
        node.parent = g;
        node.right = p;
        p.left = node.right;
        p.parent = node;
    }

    private int color(TreeNode node){
        if (node == null){
            return BLACK;
        } else {
            return node.color;
        }
    }

    /**
     * 获取叔父节点
     * @param node
     * @return
     */
    private TreeNode uncleNode(TreeNode node){
        if (node.parent == node.parent.parent.left){
            return node.parent.parent.right;
        } else {
            return node.parent.parent.left;
        }
    }

    public void insert(TreeNode root, int key){
        TreeNode newNode = new TreeNode(key);
        TreeNode node = root;
        TreeNode p = null;
        while (node != null){
            p = node;
            if (node.key > newNode.key){
                node = node.left;
            } else {
                node = node.right;
            }
        }

        newNode.parent = p;
        if (p != null){
            if (p.key > newNode.key){
                p.left = newNode;
            } else {
                p.right = newNode;
            }
        } else {
            this.root = newNode;
        }
        insertCase1(newNode);
    }

    /**
     * 情形1，新节点为根节点，直接变色
     * @param node
     */
    private void insertCase1(TreeNode node){
        if (node.parent == null){
            node.color = BLACK;
            return;
        }
        insertCase2(node);
    }

    /**
     * 情形2，父节点为黑色，依然保存平衡
     * @param node
     */
    private void insertCase2(TreeNode node){
        if (color(node.parent) == BLACK)
            return;
        insertCase3(node);
    }

    /**
     * 情形3，父节点和叔父节点均为红色，将父节点和叔父节点改为黑色，祖父节点改为红色，祖父节点重复情形1
     * @param node
     */
    private void insertCase3(TreeNode node){
        if (color(uncleNode(node)) == RED){
            node.parent.color = BLACK;
            uncleNode(node).color = BLACK;
            grandfatherNode(node).color = RED;
            insertCase1(grandfatherNode(node));
        } else {
            insertCase4(node);
        }
    }

    /**
     * 情形4，父节点为红色，且父节点为其父的左孩子，叔父节点为黑色或者缺失，且新节点为其父的右孩子。先左旋转，然后进入情形5
     */
    private void insertCase4(TreeNode node){
        if (node == node.parent.right && node.parent == grandfatherNode(node).left){//左右型
            leftRotate(node);
            node = node.left;
        } else if (node == node.parent.left && node.parent == grandfatherNode(node).right){//右左型
            rightRotate(node);
            node = node.right;
        }
        insertCase5(node);
    }

    /**
     * 情形5，父节点为红色且为其父的左孩子叔父节点缺失或为黑色，新节点为其父节点的左孩子，
     * @param node
     */
    private void insertCase5(TreeNode node){
        node.parent.color = BLACK;
        grandfatherNode(node).color = RED;
        if (node == node.parent.left && node.parent == grandfatherNode(node).left){
            rightRotate(node.parent);
        } else {
            leftRotate(node.parent);
        }
    }

    public static void main(String[] args) {
        AlgorithmRedBlackTree redBlackTree = new AlgorithmRedBlackTree();
        redBlackTree.insert(redBlackTree.root, 1);
        redBlackTree.insert(redBlackTree.root, 2);
        redBlackTree.insert(redBlackTree.root, 3);
        redBlackTree.insert(redBlackTree.root, 4);
        redBlackTree.insert(redBlackTree.root, 5);
        System.out.println("ok");
    }
}
