package data_structure.tree.heap;

import data_structure.array.Array;

/**
 * @ProjectName: algorithm
 * @Description: 最大堆结构实现（底层动态数组）
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/25 10:11
 * @Version: 1.0.0
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> array;

    public MaxHeap(int capacity) {
        array = new Array<E>(capacity);
    }

    public MaxHeap() {
        array = new Array<E>();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取某节点的父节点索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent node");
        }
        return (index - 1) / 2;
    }

    /**
     * 获取当前节点的左子节点索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 获取当前节点的右子节点索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void add(E e) {
        array.addLast(e);
        siftUp(array.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && array.get(k).compareTo(array.get(parent(k))) > 0) {
            array.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E getMax() {
        if (array.isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        return array.get(0);
    }

    public E extractMax() {
        E temp = getMax();
        array.swap(0, array.getSize() - 1);
        array.removeLast();
        siftDown(0);
        return temp;
    }

    private void siftDown(int k) {
        while (leftChild(k) < array.getSize()) {
            int maxChildIndex = leftChild(k);
            if (maxChildIndex + 1 < array.getSize() && array.get(maxChildIndex).compareTo(array.get(maxChildIndex + 1)) < 0) {
                maxChildIndex++;
            }
            if (array.get(k).compareTo(array.get(maxChildIndex)) < 0) {
                array.swap(k, maxChildIndex);
                k = maxChildIndex;
            } else {
                break;
            }
        }
    }

    /**
     * 取出最大元素，再放入一个新元素
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E temp = array.get(0);
        array.set(0, e);
        siftDown(0);
        return temp;
    }


    /**
     * 将任意数组整理成堆的形状
     *

     heapify（将任意数组整理成堆的形状）
     实现：将n个元素逐个插入到一个空堆中，算法复杂度是O(logn)

     优化：heapify（算法复杂度是O(n)）
     将任意一个数组看成完全二叉树（尽管元素的位置不对）
     找到最后一个非叶子节点（最后一个节点的父节点）
     从最后一个非叶子节点倒着不断的对每个节点siftDown就可以了
     */
}
