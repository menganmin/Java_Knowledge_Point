package com.mam.pattern.template;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 具体子类
 **/
public class ConcreteClassCaiXin extends AbstractClass{
    @Override
    public void pourVegetable() {
        System.out.println("菜心");
    }

    @Override
    public void pourSauce() {
        System.out.println("调料是蒜蓉");
    }
}
