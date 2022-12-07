package com.mam.pattern.command;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anmin
 * @Date 2022/12/07
 **/
public class Order {

    //餐桌号码
    private int diningTable;
    //所下的餐品及份数
    private Map<String,Integer> map = new HashMap<>();

    public int getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(int diningTable) {
        this.diningTable = diningTable;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setFood(String name,int num) {
        map.put(name,num);
    }
}
