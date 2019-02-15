package data_structure.set;

import data_structure.set.impl.BSTSet;
import data_structure.set.impl.LinkedListSet;
import org.junit.Test;

/**
 * @ProjectName: algorithm
 * @Description: set接口测试
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/23 13:12
 * @Version: 1.0.0
 */
public class SetTest {

    /**
     * 测试二分搜索树实现的set
     */
    @Test
    public void test1() {

        BSTSet<Integer> bstSet = new BSTSet();

        for (int i = 0; i < 20; i++) {
            bstSet.add(5);
        }
        System.out.println(bstSet.getSize());
    }

    /**
     * 测试链表实现的set
     */
    @Test
    public void test2() {

        LinkedListSet<Integer> linkedListSet = new LinkedListSet();

        for (int i = 0; i < 20; i++) {
            linkedListSet.add(5);
        }
        System.out.println(linkedListSet.getSize());
    }
}
