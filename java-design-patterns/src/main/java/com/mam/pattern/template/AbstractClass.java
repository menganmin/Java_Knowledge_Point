package com.mam.pattern.template;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 抽象类（定义模板方法和抽象方法）
 **/
public abstract class AbstractClass {

    //模板方法定义，定义执行的顺序过程，用final修饰是为了不让子类去修改执行顺序
    public final void cookProcess(){
        pourOil();
        heatOil();
        pourVegetable();
        pourSauce();
        fly();
    }

    public void pourOil(){
        System.out.println("倒油");
    }
    public void heatOil(){
        System.out.println("热油");
    }

    public abstract void pourVegetable();

    public abstract void pourSauce();

    public void fly(){
        System.out.println("翻炒");
    }
}
