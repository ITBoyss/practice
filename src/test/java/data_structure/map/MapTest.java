package data_structure.map;

import data_structure.map.impl.LinkedListMap;
import org.junit.Test;

/**
 * @ProjectName: algorithm
 * @Description: map映射结构实现类测试
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/23 16:01
 * @Version: 1.0.0
 */
public class MapTest {

    @Test
    public void test1() {
        Map<Integer, String> map = new LinkedListMap<Integer, String>();

        for (int i = 0; i < 20; i++) {
            map.add(i, "v" + i);
            map.add(i, "v" + i + 1);
        }
        System.out.println(map.getSize());
        System.out.println(map.get(6));
    }
}
