package com.mam.pattern.observer;

/**
 * @Author Anmin
 * @Date 2022/12/07
 **/
public class Client {
    public static void main(String[] args) {
        //1.创建公众号对象
        SubscriptionSubject subject = new SubscriptionSubject();
        //添加微信用户
        subject.attach(new WeiXinUser("小白"));
        subject.attach(new WeiXinUser("小红"));
        subject.attach(new WeiXinUser("小老弟"));

        //发送消息给观察者
        subject.notify("小飞棍来咯");
    }
}
