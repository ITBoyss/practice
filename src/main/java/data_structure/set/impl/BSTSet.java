package data_structure.set.impl;

import data_structure.set.Set;
import data_structure.tree.binarysearchtree.BST;

/**
 * @ProjectName: algorithm
 * @Description: Set接口实现类
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/23 13:08
 * @Version: 1.0.0
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST bst;

    public BSTSet() {
        bst = new BST();
    }


    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }
}
