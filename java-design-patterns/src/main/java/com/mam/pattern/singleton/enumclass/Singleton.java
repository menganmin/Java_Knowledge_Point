package com.mam.pattern.singleton.enumclass;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 单例模式- 枚举方式
 * 枚举类实现单例模式是极力推荐的单例实现模式，因为枚举本身就是线程安全的，并且只会加载一次
 * 属于饿汉式
 **/
public enum Singleton {
    INSTANCE;
}
