package proxy.static_proxy;

import proxy.static_proxy.impl.A;
import proxy.static_proxy.proxy.Aproxy;

/**
 * @ProjectName: algorithm
 * @Description: 静态代理测试（在程序执行之前就应经存在编译好的代理对象）
 * @Author: WeiLingYun
 * @CreateDate: 2019/1/10 15:42
 * @Version: 1.0.0
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        IA ia = new A();
        Aproxy aproxy = new Aproxy(ia);
        aproxy.f1("ceshi");
    }
}

