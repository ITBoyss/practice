package data_structure.array;

import org.junit.Test;

/**
 * @ProjectName: algorithm
 * @Description: Array测试
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/17 17:29
 * @Version: 1.0.0
 */
public class ArrayTest {


    @Test
    public void test1() {
        Array<Integer> arr = new Array(10);
        for (int i = 0; i < 10; i++) {
            arr.add(i, i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arr.get(i));
        }

        //arr.add(7, 11);
//        System.out.println(arr);
//        arr.set(0, 100);
//        System.out.println(arr);
//        arr.remove(9);
//        System.out.println(arr);
//        System.out.println(arr.find(4));
//        arr.removeFirst();
//        System.out.println(arr);
//        arr.removeLast();
//        System.out.println(arr);

        for (int i = 0;i<5;i++){
            arr.removeFirst();
        }
        System.out.println(arr);
    }
}
