package com.mam.pattern.strategy;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 环境类，承接上下文
 **/
public class SaleMan {
    //聚合策略类对象
    private Strategy strategy;

    public SaleMan(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void saleShow(){
        strategy.show();
    }
}
