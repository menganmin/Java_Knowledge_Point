package com.mam.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Anmin
 * @Date 2022/12/07
 *具体被观察者(主题实现类)
 **/
public class SubscriptionSubject implements Subject{

    private List<Observer> weiXinUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weiXinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weiXinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weiXinUserList) {
            observer.update(message);
        }
    }
}
