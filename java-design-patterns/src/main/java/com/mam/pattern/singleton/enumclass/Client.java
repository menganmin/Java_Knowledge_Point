package com.mam.pattern.singleton.enumclass;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance1 = Singleton.INSTANCE;
        System.out.println(instance == instance1);
    }
}
