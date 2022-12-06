package com.mam.pattern.proxy.jdk_proxy;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 真实主题类,目标对象 -> 火车站卖票点
 **/
public class TrainStation implements SellTickets {
    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
