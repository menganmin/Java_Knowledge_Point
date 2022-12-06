package com.mam.pattern.decorator;

/**
 * @Author Anmin
 * @Date 2022/12/06
 **/
public class Client {
    public static void main(String[] args) {
        FastFood food = new FriedRice();
        System.out.println(food.getDesc() + ":" + food.cost());
        System.out.println("==========");
        food = new Egg(food);
        System.out.println(food.getDesc() + ":" + food.cost());
        System.out.println("===========");
        food = new Bacon(food);
        System.out.println(food.getDesc() + ":" + food.cost());
    }
}
