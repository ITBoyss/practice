package data_structure.map.impl;

import data_structure.map.Map;

/**
 * @ProjectName: algorithm
 * @Description: 利用二分搜索树实现映射map
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/23 16:24
 * @Version: 1.0.0
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {

        public K key;

        public V value;

        public Node left;

        public Node right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(K key, V value) {
            this(key, value, null, null);
        }

        public Node() {
            this(null, null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node root;

    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {

        if (node == null) {
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    public Node getNode(K key) {
        return getNode(root, key);
    }

    private Node getNode(Node node, K key) {

        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(key);
        return node == null ? false : true;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist");
        }
        node.value = newValue;
    }

    public Node minimum() {
        if (root == null) {
            throw new IllegalArgumentException("Map is empty");
        }
        return minimum(root);
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public Node removeMin() {
        Node minNode = minimum();
        root = removeMin(root);
        return minNode;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node minRigth = node.right;
            node.right = null;
            size--;
            return minRigth;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = remove(root, key);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = null;
            node.right = null;
            return successor;
        }
    }
}
