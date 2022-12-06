package com.mam.pattern.proxy.static_proxy;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 代理对象 -> 代售点
 **/
public class ProxyPoint implements SellTickets{

    private TrainStation trainStation = new TrainStation();
    @Override
    public void sell() {
        System.out.println("代售点收取一点费用");
        trainStation.sell();
    }
}
