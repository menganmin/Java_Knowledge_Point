package com.mam.pattern.adapter.class_adapter;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 目标接口
 **/
public interface SDCard {
    //从SD卡中读数据
    public String readSD();
    //往SD卡中写数据
    public void writeSD(String msg);
}
