package com.mam.pattern.adapter.class_adapter;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 适配器类
 * 继承适配者类，实现目标接口
 **/
public class SDAdapterTF extends TFCardImpl implements SDCard{
    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        writeTF(msg);
    }
}
