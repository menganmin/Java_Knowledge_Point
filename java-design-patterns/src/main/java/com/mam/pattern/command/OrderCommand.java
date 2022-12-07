package com.mam.pattern.command;

import java.util.Map;
import java.util.Set;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 具体的命令类
 **/
public class OrderCommand implements Command{

    //持有接收者对象
    private SeniorChef receiver;
    private Order order;

    public OrderCommand(SeniorChef receiver, Order order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "桌的订单准备做");
        Map<String, Integer> orderMap = order.getMap();
        Set<String> keySet = orderMap.keySet();
        for (String foodName : keySet) {
            receiver.makeFood(foodName,orderMap.get(foodName));
        }
        System.out.println(order.getDiningTable() + "桌的订单已经做好了");
    }
}
