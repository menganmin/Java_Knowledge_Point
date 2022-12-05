package com.mam.pattern.factory.static_factory;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class SimpleCoffeeFactory {
    public static Coffee provide(String type){
        Coffee coffee;
        if("american".equals(type)){
            coffee = new AmericanCoffee();
        }else if("latte".equals(type)){
            coffee = new LatteCoffee();
        }else{
            throw new IllegalArgumentException("参数不合法");
        }
        return coffee;
    }
}
