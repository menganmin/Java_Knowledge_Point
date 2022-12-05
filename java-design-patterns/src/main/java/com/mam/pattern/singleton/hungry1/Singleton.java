package com.mam.pattern.singleton.hungry1;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 饿汉式 成员变量
 **/
public class Singleton {

    //私有构造方法
    private Singleton(){}

    //在本类中创建本类对象
    private static Singleton singleton = new Singleton();

    public static Singleton getInstance(){
        return singleton;
    }
}
