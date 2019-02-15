package data_structure.queue;

/**
 * @ProjectName: algorithm
 * @Description: 队列数据结构实现接口
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/18 10:27
 * @Version: 1.0.0
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}

