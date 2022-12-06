package com.mam.pattern.adapter.class_adapter;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 目标接口类
 **/
public class SDCardImpl implements SDCard{
    @Override
    public String readSD() {
        String msg = "从SDCard读取数据";
        return msg;
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SDCard write" + msg);
    }
}
