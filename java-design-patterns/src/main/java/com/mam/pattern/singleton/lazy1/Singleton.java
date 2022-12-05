package com.mam.pattern.singleton.lazy1;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 懒汉式
 **/
public class Singleton {
    //构造私有
    private Singleton(){}

    //声明变量
    private static Singleton singleton;

    //对外提供访问方法
    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
