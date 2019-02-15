package proxy.dynamic_proxy;

import proxy.dynamic_proxy.impl.A;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: algorithm
 * @Description: TODO
 * @Author: WeiLingYun
 * @CreateDate: 2019/1/10 16:09
 * @Version: 1.0.0
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        IA target = new A();
        InvocationHandler handler = new MyInvocationHandler(target);
        IA proxyInstance = (IA) Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(), target.getClass().getInterfaces(), handler);
        proxyInstance.f1("你大爷");

        int accessFlags = Modifier.PUBLIC | Modifier.FINAL;
        System.out.println(accessFlags);
    }
}
