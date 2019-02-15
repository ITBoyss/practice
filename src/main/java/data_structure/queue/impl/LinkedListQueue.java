package data_structure.queue.impl;

import data_structure.queue.Queue;

/**
 * @ProjectName: algorithm
 * @Description: 链表实现队列
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/19 16:20
 * @Version: 1.0.0
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;

        public Node next;

        public Node(E e, Node node) {
            this.e = e;
            this.next = node;
        }

        public Node(E e) {
            this(e, null);
        }
    }

    private Node head, tail;

    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (isEmpty()) {
            tail = new Node(e);
            head = tail;
        } else {
            Node node = new Node(e);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("dequeue failed, because queue is empty");
        }
        Node node = head;
        head = head.next;
        node.next = null;
        size--;
        return node.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front[");
        Node cur = head;
        while (cur!= null) {
            sb.append(cur.e + "->");
            cur = cur.next;
        }
        sb.append("NULL]tail");
        return sb.toString();
    }
}
