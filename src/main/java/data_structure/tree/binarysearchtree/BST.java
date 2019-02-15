package data_structure.tree.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ProjectName: algorithm
 * @Description: 二分搜索树结构定义
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/21 10:09
 * @Version: 1.0.0
 */
public class BST<E extends Comparable<E>> {

    private class Node {

        public E e;

        public Node left;

        public Node right;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public Node(E e) {
            this(e, null, null);
        }
    }

    private Node root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根节点的bst中插入元素e，递归算法
     * <p>
     * 返回插入新节点后二分搜索树的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 查看树中是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 查看根节点node的二分搜索树中是否存在元素e
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        }

        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前（根）序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    /**
     * 先根序遍历的非递归实现
     */
    public void NRPreOrder() {

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中（根）序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后（根）序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 广度优先遍历（层序遍历）
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树中最小值
     *
     * @return
     */
    public E minimum() {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树最大值
     *
     * @return
     */
    public E maximum() {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除二分搜索树中最小的值
     *
     * @return
     */
    public E removeMin() {
        E e = minimum();
        root = removeMin(root);
        return e;
    }

    private Node removeMin(Node node) {

        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除二分搜索树中最大的值
     *
     * @return
     */
    public E removeMax() {
        E max = maximum();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除任意节点
     *
     * @param e
     */
    public void remove(E e) {
        remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return node;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        if (e.compareTo(node.e) == 0) {
            //删除右节点为空的根节点
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }
            //删除左节点为空的根节点
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            /**
             * 删除左右节点都不为空的根节点，删除后，此根节点的子节点需要重新构建一个树
             *
             *  树的根节点有两种选择：
             *      1、原根节点右子树的最小值
             *      2、原根节点左子树的最大值
             */
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = null;
            node.right = null;
            return successor;
        }
        return node;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
