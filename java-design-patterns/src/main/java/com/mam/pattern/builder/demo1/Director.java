package com.mam.pattern.builder.demo1;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 指挥者
 **/
public class Director {
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    //组装自行车的功能
    public Bike construct(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }

}
