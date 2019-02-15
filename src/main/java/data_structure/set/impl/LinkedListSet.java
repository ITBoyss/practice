package data_structure.set.impl;

import java.util.LinkedList;

/**
 * @ProjectName: algorithm
 * @Description: 使用链表实现set
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/23 13:31
 * @Version: 1.0.0
 */
public class LinkedListSet<E> extends LinkedList<E> {

    private LinkedList<E> linkedList;

    public LinkedListSet(){
        linkedList = new LinkedList<E>();
    }

    public int getSize() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }


    @Override
    public boolean contains(Object o) {
        return linkedList.contains(o);
    }


    @Override
    public boolean add(E e){
        if (!linkedList.contains(e)){
            linkedList.addFirst(e);
        }
        return false;
    }

    @Override
    public boolean remove(Object e){
        return linkedList.remove(e);
    }
}
