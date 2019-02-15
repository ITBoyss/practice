package data_structure.tree.trie;

import java.util.TreeMap;

/**
 * @ProjectName: algorithm
 * @Description: 字典树  前缀树
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/27 9:37
 * @Version: 1.0.0
 */
public class Trie {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<Character, Node>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    private int size;

    public int getSize() {
        return size;
    }

    public Trie() {
        root = new Node();
        size = 0;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean startWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
