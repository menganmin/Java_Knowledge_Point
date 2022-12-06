package com.mam.pattern.decorator;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 具体构件角色 -> 炒饭
 **/
public class FriedRice extends FastFood{

    public FriedRice(){
        super(10,"炒饭");
    }
    @Override
    public float cost() {
        return getPrice();
    }
}
