package com.mam.pattern.factory.config_factory;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class Client {
    public static void main(String[] args) {
        Coffee american = CoffeeFactory.createCoffee("american");
        System.out.println(american.getName());

        System.out.println("==========");
        Coffee latte = CoffeeFactory.createCoffee("latte");
        System.out.println(latte.getName());
    }
}
