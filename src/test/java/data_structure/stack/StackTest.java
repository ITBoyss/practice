package data_structure.stack;

import data_structure.stack.impl.ArrayStack;
import data_structure.stack.impl.LinkedListStack;
import org.junit.Test;

/**
 * @ProjectName: algorithm
 * @Description: 测试自定义栈的实现
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/17 21:46
 * @Version: 1.0.0
 */
public class StackTest {

    /**
     * 数组栈测试
     */
    @Test
    public void test1() {
        Stack<Integer> stack = new ArrayStack<Integer>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

    /**
     * 链表栈测试
     */
    @Test
    public void test2() {
        Stack<Integer> stack = new LinkedListStack<Integer>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        for (int i = 0; i < 10; i++) {
            stack.pop();
            System.out.println(stack);
        }
    }

    /**
     * 数组栈和链表栈性能对比
     * <p>
     * 时间复杂度一样；差异不是很大
     */
    @Test
    public void test3() {
        int opCount = 100000;
        Stack<Integer> arrayStack = new ArrayStack<Integer>();
        System.out.println("ArrayStack: time = " + performance(arrayStack, opCount));

        Stack<Integer> linkedListStack = new LinkedListStack<Integer>();
        System.out.println("LinkedListStack: time = " + performance(linkedListStack, opCount));
    }

    public double performance(Stack stack, int opCount) {
        long start = System.nanoTime();

        for (int i = 0; i < opCount; i++) {
            stack.push(i);
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long end = System.nanoTime();

        return (end - start) / 1000000000.0;
    }
}
