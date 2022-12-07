package com.mam.pattern.command;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 对调用者跟接收者进行解耦
 **/
public class Client {
    public static void main(String[] args) {
        //创建订单
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFood("西红柿炒鸡蛋",2);
        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFood("鸡汤啦",1);

        //创建厨师
        SeniorChef receiver = new SeniorChef();
        //创建命令对象
        Command command1 = new OrderCommand(receiver,order1);
        Command command2 = new OrderCommand(receiver,order2);
        //创建调用者
        Waiter invoke = new Waiter();
        invoke.setCmd(command1);
        invoke.setCmd(command2);

        //发起订单命令
        invoke.orderUp();
    }
}
