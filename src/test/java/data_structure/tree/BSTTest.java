package data_structure.tree;

import data_structure.tree.binarysearchtree.BST;
import org.junit.Test;

import java.util.Random;

/**
 * @ProjectName: algorithm
 * @Description: 二分搜索树测试
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/21 14:21
 * @Version: 1.0.0
 */
public class BSTTest {

    @Test
    public void test1() {
        BST<Integer> bst = new BST<Integer>();
        for (int i = 0; i < 20; i++) {
            bst.add(new Random().nextInt(20));
        }
        bst.levelOrder();
        System.out.println("======================");
        bst.remove(10);
        bst.remove(0);
        System.out.println("======================");
        bst.levelOrder();



    }
}
