package com.mam.pattern.visitor;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 具体元素角色类
 **/
public class Cat implements Animal{
    @Override
    public void accept(Person person) {
        person.feed(this);//访问者给猫喂食
        System.out.println("好好吃哈");
    }
}
