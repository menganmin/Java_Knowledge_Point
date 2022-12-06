package com.mam.pattern.adapter.object_adapter;

/**
 * @Author Anmin
 * @Date 2022/12/06
 **/
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println("=============");

        //使用该电脑读取TF卡中的数据
        //定义适配器类对象
        SDAdapterTF sdAdapterTF = new SDAdapterTF(new TFCardImpl());
        String msg1 = computer.readSD(sdAdapterTF);
        System.out.println(msg1);
    }
}
