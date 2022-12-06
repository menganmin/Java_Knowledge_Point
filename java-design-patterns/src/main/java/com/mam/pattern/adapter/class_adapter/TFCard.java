package com.mam.pattern.adapter.class_adapter;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 适配者类的接口
 **/
public interface TFCard {

    //从TF卡中读数据
    public String readTF();
    //往TF卡中写数据
    public void writeTF(String msg);
}
