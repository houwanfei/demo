package com.example.demo.algorithm;

public class AlgorithmAVLTree {
    public TreeNode root;

    class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int height;
        int key;

        public TreeNode(int key) {
            this.key = key;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 获取节点高度
     * @param node
     * @return
     */
    public int height(TreeNode node){
        if (node == null)
            return 0;
        else
            return node.height;
    }

    /**
     * 左左型旋转，返回新的根节点（该子树）
     *          3
     *         /
     *        2
     *       /
     *      1
     * @param root
     * @return
     */
    public TreeNode leftLeftRotate(TreeNode root){
        TreeNode cur = root;
        TreeNode newRoot = cur.left;
        cur.left = newRoot.right;
        newRoot.right = cur;
        cur.height = Math.max(height(cur.left), height(cur.right))+1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right))+1;
        return newRoot;
    }

    /**
     * 右右型旋转
     *          3
     *           \
     *            4
     *             \
     *              5
     * @param root
     * @return
     */
    public TreeNode rightRightRotate(TreeNode root){
        TreeNode cur = root;
        TreeNode newRoot = cur.right;
        cur.right = newRoot.left;
        newRoot.left = cur;
        cur.height = Math.max(height(cur.left), height(cur.right))+1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right))+1;
        return newRoot;
    }

    /**
     * 右左型旋转
     *          3
     *           \
     *            5
     *           /
     *          4
     * 1.右子树左左型旋转
     *          3
     *           \
     *            4
     *             \
     *              5
     * 2.右右型旋转
     *           4
     *          / \
     *         3   5
     * @param root
     * @return
     */
    public TreeNode rightLeftRotate(TreeNode root){
        root.right = leftLeftRotate(root.right);
        return rightRightRotate(root);
    }

    /**
     * 左右型旋转
     *          3
     *         /
     *        1
     *         \
     *          2
     *  1.左子树右右型旋转
     *          3
     *         /
     *        2
     *       /
     *      1
     *  2.左左型旋转
     *          2
     *         / \
     *        1   3
     * @param root
     * @return
     */
    public TreeNode leftRightRotate(TreeNode root){
        root.left = rightRightRotate(root.left);
        return leftLeftRotate(root);
    }


    public TreeNode insert(TreeNode root, int key){
        if (root == null){
            return new TreeNode(key);
        }

        if (root.key > key){
            root.left = insert(root.left, key);
            //判断插入后值是否打破平衡
            if (height(root.left) - height(root.right) == 2){
                if (root.left.key > key){
                    //左左型
                    root = leftLeftRotate(root);
                } else {
                    root = leftRightRotate(root);
                }
            }
        } else if (root.key < key){
            root.right = insert(root.right, key);
            if (height(root.right) - height(root.left) == 2){
                if (root.right.key < key){
                    root = rightRightRotate(root);
                } else {
                    root =rightLeftRotate(root);
                }
            }
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return root;
    }

    /**
     * 删除
     * @param root
     * @param key
     * @return
     */
    public TreeNode delete(TreeNode root, int key){
        if (root == null){
            return null;
        }

        if (root.key > key){
            root.left = delete(root.left, key);
            //判断树是否平衡
            if (height(root.right) - height(root.left) == 2){
                if (height(root.right.left) > height(root.right.right)) {//右左型
                    root = rightLeftRotate(root);
                } else {
                    root = rightRightRotate(root);
                }
            }
        } else if (root.key < key){
            root.right = delete(root.right, key);
            //判断树是否平衡
            if (height(root.left) - height(root.right) == 2){
                if (height(root.left.left) > height(root.left.right)){//左左型
                    root = leftLeftRotate(root);
                } else {
                    root = leftRightRotate(root);
                }
            }
        } else {
            //左右子树不为空
            if (root.right != null && root.left != null){
                TreeNode delNode = min(root.right);
                root.key = delNode.key;
                root.right = delete(root.right, delNode.key);
            } else {
                root = root.left == null ? root.right : root.left;
                if (root == null)
                    return null;
            }
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return root;
    }

    /**
     * 查找以root为根节点的最小值
     * @param root
     * @return
     */
    public TreeNode min(TreeNode root){
        if (root == null)
            return null;
        if (root.left != null)
            return min(root.left);
        else
            return root;
    }

    public static void main(String[] args) {
        AlgorithmAVLTree avlTree = new AlgorithmAVLTree();
        avlTree.root = avlTree.insert(avlTree.root, 1);
        avlTree.root = avlTree.insert(avlTree.root, 2);
        avlTree.root = avlTree.insert(avlTree.root, 3);
        avlTree.root = avlTree.insert(avlTree.root, 4);
        avlTree.root = avlTree.insert(avlTree.root, 5);
        avlTree.root = avlTree.insert(avlTree.root, 6);
        avlTree.root = avlTree.insert(avlTree.root, 7);
        avlTree.root = avlTree.delete(avlTree.root, 6);
        avlTree.root = avlTree.delete(avlTree.root, 7);
        avlTree.root = avlTree.delete(avlTree.root, 5);
        System.out.println("ok");
    }
}
