package com.mam.pattern.factory.abstract_factory;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 意大利风味甜品工厂
 **/
public class ItalyDessertFactory implements DessertFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Tiramisu();
    }
}
