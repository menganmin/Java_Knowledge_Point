package com.mam.pattern.observer;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 具体的观察者类
 **/
public class WeiXinUser implements Observer{

    //微信用户的名称
    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "收到：" + message);
    }
}
