package com.mam.pattern.strategy;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 策略模式
 **/
public class Client {
    public static void main(String[] args) {
        SaleMan saleMan = new SaleMan(new StrategyA());
        saleMan.saleShow();

        System.out.println("==============");
        saleMan = new SaleMan(new StrategyB());
        saleMan.saleShow();
    }
}
