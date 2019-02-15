package proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ProjectName: algorithm
 * @Description: TODO
 * @Author: WeiLingYun
 * @CreateDate: 2019/1/10 16:02
 * @Version: 1.0.0
 */
public class MyInvocationHandler implements InvocationHandler {

    //被代理对象，Object类型
    private Object target;

    public MyInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy start.....");
        Object invoke = method.invoke(target, args);
        System.out.println("proxy end......");
        return invoke;
    }
}
