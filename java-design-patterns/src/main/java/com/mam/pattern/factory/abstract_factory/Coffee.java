package com.mam.pattern.factory.abstract_factory;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public abstract class Coffee {

    public abstract String getName();

    public void addSugar(){
        System.out.println("加糖");
    }
    public void addMilk(){
        System.out.println("加奶");
    }
}
