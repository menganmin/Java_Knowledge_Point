package com.mam.pattern.singleton.hungry2;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 饿汉式 静态代码块
 **/
public class Singleton {

    //私有构造方法
    private Singleton(){}

    //声明变量
    private static Singleton singleton;//null

    //静态代码块
    static {
        singleton = new Singleton();
    }

    //提供对外的方法
    public static Singleton getInstance(){
        return singleton;
    }
}
