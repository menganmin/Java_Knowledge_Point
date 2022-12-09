package com.mam.framework.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 用户存储和管理多个PropertyValue对象
 **/
public class MutablePropertyValue implements Iterable<PropertyValue> {

    //定义一个list对象，用来存储PropertyValue对象
    private final List<PropertyValue> propertyValueList;

    public MutablePropertyValue() {
        this.propertyValueList = new ArrayList<>();
    }

    public MutablePropertyValue(List<PropertyValue> propertyValueList) {
        if(propertyValueList == null){
            this.propertyValueList = new ArrayList<>();
        }else{
            this.propertyValueList = propertyValueList;
        }
    }

    //获取所有PropertyValue对象，返回以数组的形式
    public PropertyValue[] getPropertyValues(){
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    //根据name属性获取PropertyValue对象
    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue propertyValue : propertyValueList) {
            if(propertyValue.getName().equals(propertyName)){
                return propertyValue;
            }
        }
        return null;
    }

    //判断集合是否为空
    public boolean isEmpty(){
        return propertyValueList.isEmpty();
    }

    //添加PropertyValue对象
    public MutablePropertyValue addPropertyValue(PropertyValue pv){
        //判断集合中存储的对象是否和传递进来的对象重复了，如果重复，则覆盖
        for (int i = 0; i < propertyValueList.size(); i++) {
            PropertyValue currentPv = propertyValueList.get(i);
            if(currentPv.getName().equals(pv.getName())){
                propertyValueList.set(i,pv);
                return this;
            }
        }
        propertyValueList.add(pv);
        return this;//目的实现链式编程
    }

    //判断是否有指定name属性值的对象
    public boolean contains(String propertyName){
        return getPropertyValue(propertyName) != null;
    }

    //获取迭代器对象
    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }
}
