package com.mam.pattern.builder.demo1;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 抽象构建者
 **/
public abstract class Builder {

    //声明bike类型的变量，并进行赋值
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Bike createBike();
}
