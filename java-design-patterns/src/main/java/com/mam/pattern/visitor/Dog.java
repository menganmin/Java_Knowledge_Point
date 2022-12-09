package com.mam.pattern.visitor;

/**
 * @Author Anmin
 * @Date 2022/12/08
 **/
public class Dog implements Animal{
    @Override
    public void accept(Person person) {
        person.feed(this);//访问者给狗喂食
        System.out.println("好好吃哈");
    }
}
