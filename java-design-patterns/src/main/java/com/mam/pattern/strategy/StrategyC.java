package com.mam.pattern.strategy;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 具体策略类,封装算法
 **/
public class StrategyC implements Strategy{
    @Override
    public void show() {
        System.out.println("买1000元送200元");
    }
}
