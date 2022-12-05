package com.mam.pattern.singleton.static_inner;

import java.io.Serializable;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 单例模式 - 静态内部类
 * 静态内部类单例模式是一种优秀的单例模式，是开源项目中比较常见的一种单例模式。在没有加锁的情况下，保证了
 * 多线程安全性，并且没有任何性能影响和空间浪费
 **/
public class Singleton implements Serializable {
    private Singleton(){}

    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    //对外提供方法获取该类对象
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    //当进行反序列化时，会自动调用该方法，将该方法的返回值直接返回
    public Object readResolve(){
        return SingletonHolder.INSTANCE;
    }
}
