package data_structure.queue.impl;

import data_structure.queue.Queue;

/**
 * @ProjectName: algorithm
 * @Description: 循环队列实现
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/18 11:14
 * @Version: 1.0.0
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    /**
     * 队首标志
     */
    private int front;

    /**
     * 队尾标志
     */
    private int tail;

    private int size;

    public LoopQueue(int capacity) {
        //循环队列中会浪费一个空间
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data[front];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        E e = getFront();
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return e;
    }

    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = front, j = 0; i != tail; i = (i + 1) % data.length) {
            newData[j++] = data[i];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue:  size : %d ; capacity : %d \n", size, getCapacity()));
        sb.append("front [");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            if ((front + i) % data.length != tail - 1) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
