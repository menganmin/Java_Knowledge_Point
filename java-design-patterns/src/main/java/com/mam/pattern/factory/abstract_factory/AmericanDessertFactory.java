package com.mam.pattern.factory.abstract_factory;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 美式风味的甜品工厂
 **/
public class AmericanDessertFactory implements DessertFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
