package proxy.static_proxy.proxy;

import proxy.static_proxy.IA;

/**
 * @ProjectName: algorithm
 * @Description: 代理类（代理类和被代理类要实现相同的接口）
 * @Author: WeiLingYun
 * @CreateDate: 2019/1/10 15:35
 * @Version: 1.0.0
 */
public class Aproxy implements IA {

    /**
     * @Description 被代理对象
     */
    private IA target;

    /***
     * @Author lingyun.wei@hand-china.com
     * @Description 通过构造方法传入被代理对象
     * @Date 15:39 2019/1/10
     * @Param [target]
     * @return
     */
    public Aproxy(IA target) {
        this.target = target;
    }

    @Override
    public void f1(String param) {
        System.out.println("被代理对象方法执行前执行..........");
        target.f1(param);
        System.out.println("被代理对象方法执行后执行..........");
    }
}
