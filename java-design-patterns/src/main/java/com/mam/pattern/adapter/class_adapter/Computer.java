package com.mam.pattern.adapter.class_adapter;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 计算机类
 **/
public class Computer {

    //从SDCard读取数据
    public String readSD(SDCard sdCard){
        return sdCard.readSD();
    }
}
