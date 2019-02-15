package data_structure.tree;

import data_structure.tree.heap.MaxHeap;
import org.junit.Test;

import java.util.Random;

/**
 * @ProjectName: algorithm
 * @Description: 最大堆结构测试
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/25 11:16
 * @Version: 1.0.0
 */
public class MaxHeapTest {

    @Test
    public void test1() {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();

        for (int i = 0; i < 20; i++) {
            maxHeap.add(new Random().nextInt(Integer.MAX_VALUE));
        }


        int[] arr = new int[maxHeap.getSize()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        System.out.println(java.util.Arrays.asList(arr).toString());
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] < arr[i]) {
                throw new RuntimeException("MaxHeap have exception");
            }
        }
        System.out.println("MaxHeap is completed");
    }
}
