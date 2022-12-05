package com.mam.pattern.factory.before;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class CoffeeStore {

    public Coffee orderCoffee(String type){
        Coffee coffee;
        if("american".equals(type)){
            coffee = new AmericanCoffee();
        }else if("latte".equals(type)){
            coffee = new LatteCoffee();
        }else{
            throw new IllegalArgumentException("参数不合法");
        }
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
