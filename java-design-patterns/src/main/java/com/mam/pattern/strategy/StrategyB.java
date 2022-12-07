package com.mam.pattern.strategy;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 具体策略类,封装算法
 **/
public class StrategyB implements Strategy{
    @Override
    public void show() {
        System.out.println("买200元送50元");
    }
}
