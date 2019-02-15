package data_structure.linkedlist;

import org.junit.Test;

/**
 * @ProjectName: algorithm
 * @Description: 双向链表测试
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/20 16:57
 * @Version: 1.0.0
 */
public class DLinkedListTest {

    @Test
    public void test1() {

        DLinkedList<Integer> dLinkedList = new DLinkedList<Integer>();
        for (int i = 0; i < 20; i++) {
            dLinkedList.addFirst(i);
            System.out.println(dLinkedList);

            if (i % 3 == 2) {
                dLinkedList.removeLast();
                System.out.println(dLinkedList);
            }
        }
        dLinkedList.removeFirst();
        System.out.println(dLinkedList);
        dLinkedList.add(3,333);
        System.out.println(dLinkedList);
        dLinkedList.remove(3);
        System.out.println(dLinkedList);
        System.out.println(dLinkedList.getSize());
        System.out.println(dLinkedList.getFirst());
        System.out.println(dLinkedList.getLast());
    }
}
