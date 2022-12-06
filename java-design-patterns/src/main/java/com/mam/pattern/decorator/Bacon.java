package com.mam.pattern.decorator;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 具体的装饰者角色 -> 培根类
 **/
public class Bacon extends Garnish{


    public Bacon(FastFood fastFood) {
        super(2, "培根", fastFood);
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
