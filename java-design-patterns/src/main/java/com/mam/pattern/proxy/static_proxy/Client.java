package com.mam.pattern.proxy.static_proxy;

/**
 * @Author Anmin
 * @Date 2022/12/06
 **/
public class Client {
    public static void main(String[] args) {
        //创建代理对象
        ProxyPoint point = new ProxyPoint();
        point.sell();
    }
}
