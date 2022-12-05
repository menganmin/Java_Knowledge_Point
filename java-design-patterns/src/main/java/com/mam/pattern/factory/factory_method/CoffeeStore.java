package com.mam.pattern.factory.factory_method;


/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class CoffeeStore {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee(){
        return factory.createCoffee();
    }
}
