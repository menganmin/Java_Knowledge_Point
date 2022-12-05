package com.mam.pattern.singleton.lazy2;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 懒汉式 线程安全
 **/
public class Singleton {
    private Singleton(){}

    private static Singleton singleton;

    public static synchronized Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
