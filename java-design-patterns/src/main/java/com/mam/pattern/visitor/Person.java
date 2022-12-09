package com.mam.pattern.visitor;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 抽象访问者角色类
 **/
public interface Person {

    //喂狗
    void feed(Dog dog);

    //喂猫
    void feed(Cat cat);
}
