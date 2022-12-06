package com.mam.pattern.adapter.class_adapter;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 适配者类
 **/
public class TFCardImpl implements TFCard{
    @Override
    public String readTF() {
        String msg = "从TFCard读取数据";
        return msg;
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCard write" + msg);
    }
}
