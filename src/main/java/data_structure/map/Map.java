package data_structure.map;

/**
 * @ProjectName: algorithm
 * @Description: 自定义实现映射数据结构接口
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/23 14:53
 * @Version: 1.0.0
 */
public interface Map<K, V> {

    void add(K key, V value);

    V get(K key);

    V remove(K key);

    void set(K key, V newValue);

    boolean isEmpty();

    boolean contains(K key);

    int getSize();
}
