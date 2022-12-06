package com.mam.pattern.facade;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 外观模式
 **/
public class Client {
    public static void main(String[] args) {
        SmartApplicationFacade smartApplicationFacade = new SmartApplicationFacade();
        smartApplicationFacade.say("开");
        System.out.println("=============");
        smartApplicationFacade.say("关");
    }
}
