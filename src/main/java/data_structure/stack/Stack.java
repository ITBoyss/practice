package data_structure.stack;

/**
 * @ProjectName: algorithm
 * @Description: 实现栈结构的接口
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/17 21:24
 * @Version: 1.0.0
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();

}
