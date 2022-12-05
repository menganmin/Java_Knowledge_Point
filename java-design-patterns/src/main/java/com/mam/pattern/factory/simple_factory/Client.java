package com.mam.pattern.factory.simple_factory;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 简单工厂
 **/
public class Client {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("latte");
        System.out.println(coffee.getName());
        coffee.addSugar();
        coffee.addMilk();
    }
}
