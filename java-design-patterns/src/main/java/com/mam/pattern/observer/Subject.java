package com.mam.pattern.observer;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 抽象主题角色类
 **/
public interface Subject {

    //添加订阅者
    void attach(Observer observer);

    //删除订阅者
    void detach(Observer observer);

    //通知订阅者更新消息
    void notify(String message);
}
