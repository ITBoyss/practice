package data_structure.linkedlist;

import org.junit.Test;

/**
 * @ProjectName: algorithm
 * @Description: 链表数据结构测试
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/19 14:20
 * @Version: 1.0.0
 */
public class LinkedListTest {

    @Test
    public void test1() {

        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for (int i = 0; i < 5; i++) {
            linkedList.addLast(i);
            System.out.println(linkedList);
        }
        linkedList.add(3, 333);
        System.out.println(linkedList);

        linkedList.remove(3);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        System.out.println(linkedList.contains(20));

    }
}
