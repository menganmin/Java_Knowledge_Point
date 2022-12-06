package com.mam.pattern.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 获取代理对象的工厂类
 **/
public class ProxyFactory {

    //声明目标对象
    private TrainStation station = new TrainStation();

    //返回值为代理对象
    public SellTickets getProxyObject(){
        /*
        ClassLoader loader      ：类加载器，用于加载代理类。可以通过目标对象获取类加载器
        Class<?>[] interfaces   ：代理类实现的接口的字节码对象
        InvocationHandler h     ：代理对象的调用处理程序
         */
        SellTickets proxyInstance = (SellTickets)Proxy.newProxyInstance(
                station.getClass().getClassLoader(),
                station.getClass().getInterfaces(),
                new InvocationHandler() {
                    /*
                    Object o        ：代理对象。和proxyInstance对象是同一个对象，在invoke方法中基本不用
                    Method method   ：对接口中的方法进行封装的method对象
                    Object[] objects：调用方法的实际参数
                    Object返回值：方法的返回值
                     */
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        //System.out.println("invoke方法执行了");
                        System.out.println("代售点收取一点费用(jdk动态代理)");
                        //执行目标对象的方法
                        Object obj = method.invoke(station, args);

                        return obj;
                    }
                }
        );
        return proxyInstance;
    }
}
