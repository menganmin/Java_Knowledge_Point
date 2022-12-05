package com.mam.pattern.singleton.hungry2;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);//true
    }
}
