package com.mam.pattern.factory.static_factory;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 简单工厂
 **/
public class Client {
    public static void main(String[] args) {
        Coffee coffee = SimpleCoffeeFactory.provide("latte");
        System.out.println(coffee.getName());
        coffee.addSugar();
        coffee.addMilk();
    }
}
