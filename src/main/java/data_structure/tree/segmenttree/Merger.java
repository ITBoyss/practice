package data_structure.tree.segmenttree;

/**
 * @ProjectName: algorithm
 * @Description: 组合器
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/26 16:53
 * @Version: 1.0.0
 */
public interface Merger<E> {

    E merge(E a, E b);
}
