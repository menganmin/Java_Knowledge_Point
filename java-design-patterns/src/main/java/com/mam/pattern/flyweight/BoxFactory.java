package com.mam.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 享元工厂角色 -> 工厂类，将该类设计为单例模式
 **/
public class BoxFactory {

    private static BoxFactory factory = new BoxFactory();

    private HashMap<String,AbstractBox> map;

    private BoxFactory(){
        map = new HashMap<>();
        map.put("I",new IBox());
        map.put("L",new LBox());
        map.put("O",new OBox());
    }
    //提供一个对外获取对象的方法
    public static BoxFactory getInstance(){
        return factory;
    }


    //根据名称获取图形对象
    public AbstractBox getShape(String name){
        return map.get(name);
    }
}
