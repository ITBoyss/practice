package data_structure.stack.impl;

import data_structure.linkedlist.LinkedList;
import data_structure.stack.Stack;

/**
 * @ProjectName: algorithm
 * @Description: 链表实现栈结构
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/19 15:24
 * @Version: 1.0.0
 */
public class LinkedListStack<E> implements Stack<E> {

    public LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListStack top [");
        sb.append(linkedList);
        sb.append("]");
        return sb.toString();
    }
}
