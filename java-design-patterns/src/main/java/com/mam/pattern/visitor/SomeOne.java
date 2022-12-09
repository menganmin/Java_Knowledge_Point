package com.mam.pattern.visitor;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 具体访问者类
 **/
public class SomeOne implements Person{
    @Override
    public void feed(Dog dog) {
        System.out.println("其他人喂狗");
    }

    @Override
    public void feed(Cat cat) {
        System.out.println("其他人喂猫");
    }
}
