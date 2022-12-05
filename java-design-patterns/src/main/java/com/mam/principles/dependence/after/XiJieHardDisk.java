package com.mam.principles.dependence.after;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class XiJieHardDisk implements HardDisk{

    //存储数据
    public void save(String data){
        System.out.println("希捷硬盘存储数据：" + data);
    }

    //获取数据
    public String get(){
        System.out.println("希捷硬盘获取数据");
        return "数据";
    }
}
