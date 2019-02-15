package proxy.dynamic_proxy.impl;


import proxy.dynamic_proxy.IA;

/**
 * @ProjectName: algorithm
 * @Description: 被代理类实现业务接口
 * @Author: WeiLingYun
 * @CreateDate: 2019/1/10 15:33
 * @Version: 1.0.0
 */
public class A implements IA {
    @Override
    public void f1(String param) {
        System.out.println("方法f1执行了........" + param);
    }
}
