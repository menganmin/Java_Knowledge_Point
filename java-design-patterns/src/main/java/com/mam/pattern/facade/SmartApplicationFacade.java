package com.mam.pattern.facade;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 外观类，用户主要和该类对象交互
 **/
public class SmartApplicationFacade {

    //聚合对象
    private Light light;
    private TV tv;
    private AirCondition airCondition;

    public SmartApplicationFacade(){
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }
    //通过语音控制
    public void say(String message){
        if(message.contains("开")){
            on();
        }else if(message.contains("关")){
            off();
        }else{
            System.out.println("语音未通过识别");
        }
    }

    //一键打开功能
    private void on(){
        light.on();
        tv.on();
        airCondition.on();
    }
    //一键关闭功能
    private void off(){
        light.off();
        tv.off();
        airCondition.off();
    }
}
