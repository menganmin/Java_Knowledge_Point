package com.mam.pattern.flyweight;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 享元模式
 **/
public class Client {
    public static void main(String[] args) {
        AbstractBox box1 = BoxFactory.getInstance().getShape("I");
        box1.display("蓝色");
        AbstractBox box2 = BoxFactory.getInstance().getShape("L");
        box2.display("红色");
        AbstractBox box3 = BoxFactory.getInstance().getShape("O");
        box3.display("绿色");
        AbstractBox box4 = BoxFactory.getInstance().getShape("O");
        box4.display("黄色");
        System.out.println("两次获取到的O图形是否是同一个对象：" + (box3 == box4));
    }
}
