package com.mam.pattern.decorator;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 抽象装饰者角色 -> 咖喱类
 **/
public abstract class Garnish extends FastFood{
    //声明抽象构件角色变量
    private FastFood fastFood;

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
    public Garnish(float price, String desc, FastFood fastFood) {
        super(price, desc);
        this.fastFood = fastFood;
    }
}
