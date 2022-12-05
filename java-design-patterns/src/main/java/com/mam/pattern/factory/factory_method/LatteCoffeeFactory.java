package com.mam.pattern.factory.factory_method;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 拿铁咖啡工厂
 **/
public class LatteCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
