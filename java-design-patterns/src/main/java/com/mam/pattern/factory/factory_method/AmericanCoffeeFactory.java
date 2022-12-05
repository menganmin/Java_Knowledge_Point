package com.mam.pattern.factory.factory_method;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 美式咖啡工厂对象，专门用来生产美式咖啡
 **/
public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
