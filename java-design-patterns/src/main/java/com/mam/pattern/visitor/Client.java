package com.mam.pattern.visitor;

/**
 * @Author Anmin
 * @Date 2022/12/08
 **/
public class Client {
    public static void main(String[] args) {
        Home home = new Home();
        home.add(new Cat());
        home.add(new Dog());

        home.action(new Owner());
    }
}
