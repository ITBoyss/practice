package data_structure.set;

/**
 * @ProjectName: algorithm
 * @Description: 实现集合数据结构
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/23 13:05
 * @Version: 1.0.0
 */
public interface Set<E extends Comparable<E>> {

    void add(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();

    boolean contains(E e);
}
