package com.mam.pattern.singleton.lazy3;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 懒汉式 双重校验模式
 **/
public class Singleton {

    private Singleton(){}

    //使用volatile可防止JVM指令重排，保证内存可见性跟有序性
    private static volatile Singleton instance;

    public static Singleton getInstance(){
        //第一次判断，如果instance不为null，不进入抢锁阶段，直接返回实例对象
        if(instance == null){
            synchronized (Singleton.class){
                //抢到锁之后再次判断是否为空
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
