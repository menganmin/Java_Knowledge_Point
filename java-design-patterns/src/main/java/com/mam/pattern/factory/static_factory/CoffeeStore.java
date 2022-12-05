package com.mam.pattern.factory.static_factory;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class CoffeeStore {

    public Coffee orderCoffee(String type){
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.provide("latte");
        return coffee;
    }
}
