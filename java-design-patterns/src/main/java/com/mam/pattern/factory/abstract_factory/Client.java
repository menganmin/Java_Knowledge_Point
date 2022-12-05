package com.mam.pattern.factory.abstract_factory;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class Client {
    public static void main(String[] args) {
        AmericanDessertFactory factory = new AmericanDessertFactory();
        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();
        System.out.println(coffee.getName());
        dessert.show();
    }
}
