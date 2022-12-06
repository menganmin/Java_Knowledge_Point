package com.mam.pattern.decorator;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 具体的装饰者角色 -> 鸡蛋类
 **/
public class Egg extends Garnish{

    public Egg(FastFood fastFood) {
        super(1, "鸡蛋", fastFood);
    }

    @Override
    public float cost() {
        //计算价格
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
