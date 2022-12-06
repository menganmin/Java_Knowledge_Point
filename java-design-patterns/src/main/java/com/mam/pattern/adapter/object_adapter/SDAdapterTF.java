package com.mam.pattern.adapter.object_adapter;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 适配器类
 * 实现目标接口,重写目标接口的方法（修改目标接口的方法，反而是使用适配者类的方法）
 **/
public class SDAdapterTF implements SDCard {
    //声明适配者类
    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard){
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }
}
