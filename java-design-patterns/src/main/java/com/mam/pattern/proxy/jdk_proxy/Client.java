package com.mam.pattern.proxy.jdk_proxy;

/**
 * @Author Anmin
 * @Date 2022/12/06
 **/
public class Client {
    public static void main(String[] args) {
        //获取代理对象
        //创建代理工厂对象
        ProxyFactory proxyFactory = new ProxyFactory();
        //获取代理对象
        SellTickets proxyObject = proxyFactory.getProxyObject();
        //调用卖票的方法
        proxyObject.sell();
    }
}
