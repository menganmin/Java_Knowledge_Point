package com.mam.pattern.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 代理对象工厂，主要用来获取代理对象
 * cglib ->代理类属于目标类的子类
 **/
public class ProxyFactory implements MethodInterceptor {

    private TrainStation station = new TrainStation();
    public TrainStation getProxyObject(){
        //创建Enhancer对象，类似jdk代理中的proxy类
        Enhancer enhancer = new Enhancer();
        //设置父类的字节码对象
        enhancer.setSuperclass(TrainStation.class);
        //设置回调函数
        enhancer.setCallback(this);
        //创建代理对象
        TrainStation proxyObject = (TrainStation)enhancer.create();
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("代售点收取一点费用(cglib动态代理)");
        //调用目标对象的方法
        Object obj = method.invoke(station, args);
        //返回值：调用目标对象的返回值
        return obj;
    }
}
