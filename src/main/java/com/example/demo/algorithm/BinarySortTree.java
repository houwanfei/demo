package com.example.demo.algorithm;

public class BinarySortTree {
    class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        public int key;
    }

    TreeNode root;

    public void insert(int key){
        TreeNode node = new TreeNode();
        node.key = key;
        node.left = null;
        node.right = null;
        if (root == null){
            node.parent = null;
            root = node;
            return;
        }
        TreeNode tmp =root;
        TreeNode cur = null;
        while (tmp != null){
            if (tmp.key == key){
                return;
            }else if (tmp.key > key){
                cur = tmp;
                tmp = tmp.left;
            }else {
                cur = tmp;
                tmp = tmp.right;
            }
        }

        node.parent = cur;
        if (cur.key > key){
            cur.left = node;
        }else {
            cur.right = node;
        }
    }

    public TreeNode min(TreeNode root){
        if (root == null){
            return null;
        }
        if (root.left != null)
            return min(root.left);
        else
            return root;
    }

    public void delete(TreeNode root, int key){
        if (root == null)
            return;
        if (root.key == key){
            if (root.left == null){
                if (root == root.parent.left){
                    root.parent.left = root.right;
                } else {
                    root.parent.right = root.right;
                }
            } else if (root.right == null){
                if (root == root.parent.left){
                    root.parent.left = root.left;
                } else {
                    root.parent.right = root.left;
                }
            } else {
                //查找右子树最小值
                TreeNode min = min(root.right);
                if (min.right != null){
                    if (min == min.parent.left){
                        min.parent.left = min.right;
                    } else {
                        min.parent.right = min.right;
                    }
                } else {
                    if (min == min.parent.left){
                        min.parent.left = null;
                    } else {
                        min.parent.right = null;
                    }
                }
                root.key = min.key;
            }
        } else if (root.key > key){
            delete(root.left, key);
        } else {
            delete(root.right, key);
        }
    }

    public TreeNode searchRecursion(TreeNode root, int key){
        if (root == null)
            return null;
        if (root.key == key){
            return root;
        } else if (root.key > key){
            return searchRecursion(root.left, key);
        } else {
            return searchRecursion(root.right, key);
        }
    }

    public void inserRecursion(TreeNode root, int key){
        if (root == null){
            TreeNode node = new TreeNode();
            node.right = null;
            node.left = null;

        }
    }

    public static void main(String[] args) {
        BinarySortTree tree = new BinarySortTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(1);
        tree.insert(6);
        tree.insert(9);
        tree.insert(7);
        tree.insert(10);
        TreeNode min = tree.min(tree.root);
        TreeNode node = tree.searchRecursion(tree.root, 3);
        tree.delete(tree.root, 8);
        System.out.println("ok");
    }
}
