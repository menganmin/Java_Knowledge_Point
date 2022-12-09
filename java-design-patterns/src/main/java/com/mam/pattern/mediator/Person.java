package com.mam.pattern.mediator;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 抽象同事类
 **/
public abstract class Person {

    protected String name;
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
