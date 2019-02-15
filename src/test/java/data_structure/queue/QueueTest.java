package data_structure.queue;

import data_structure.queue.impl.ArrayQueue;
import data_structure.queue.impl.LinkedListQueue;
import data_structure.queue.impl.LoopQueue;
import org.junit.Test;

import java.util.Random;

/**
 * @ProjectName: algorithm
 * @Description: 队列测试
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/18 10:40
 * @Version: 1.0.0
 */
public class QueueTest {

    /**
     * 数组队列测试
     */
    @Test
    public void test1() {

        Queue<Integer> queue = new ArrayQueue<Integer>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    /**
     * 循环队列测试
     */
    @Test
    public void test2() {

        Queue<Integer> queue = new LoopQueue<Integer>(5);

        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    /**
     * 不同底层实现的队列间性能对比
     */
    @Test
    public void test3() {
        int opCount = 100000;
        Queue<Integer> queue1 = new ArrayQueue<Integer>();
        double arrayTime = performance(queue1, opCount);
        System.out.println("Array time = " + arrayTime + "s");

        Queue<Integer> queue2 = new LoopQueue<Integer>();
        double loopTime = performance(queue2, opCount);
        System.out.println("Loop time = " + loopTime + "s");

        Queue<Integer> queue3 = new LinkedListQueue<Integer>();
        double linkedListTime = performance(queue3, opCount);
        System.out.println("linkedList time = " + linkedListTime + "s");
    }

    public double performance(Queue<Integer> queue, int opCount) {

        long start = System.nanoTime();

        for (int i = 0; i < opCount; i++) {
            queue.enqueue(new Random().nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long end = System.nanoTime();

        return (end - start) / 1000000000.0;
    }

    /**
     * 测试链表队列结构
     */
    @Test
    public void test4() {
        Queue<Integer> queue = new LinkedListQueue<Integer>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
