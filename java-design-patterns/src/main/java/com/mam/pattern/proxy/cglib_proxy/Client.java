package com.mam.pattern.proxy.cglib_proxy;

/**
 * @Author Anmin
 * @Date 2022/12/06
 **/
public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        TrainStation proxyObject = factory.getProxyObject();
        proxyObject.sell();
    }
}
