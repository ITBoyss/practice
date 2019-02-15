package data_structure.stack.impl;

import data_structure.array.Array;
import data_structure.stack.Stack;

/**
 * @ProjectName: algorithm
 * @Description: 基于数组的栈结构实现
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/17 21:32
 * @Version: 1.0.0
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<E>(capacity);
    }

    public ArrayStack() {
        array = new Array<E>();
    }

    /**
     * 栈添加一个元素
     *
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 栈移除一个元素
     *
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 拿出栈的元素看
     *
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 获取栈的大小
     *
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 获取栈的容量
     *
     * @return
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 查看栈是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:");
        sb.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != array.getSize() - 1) {
                sb.append(',');
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
