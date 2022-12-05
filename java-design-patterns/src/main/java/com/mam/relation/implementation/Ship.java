package com.mam.relation.implementation;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 实现关系
 **/
public class Ship implements Vehicle{
    @Override
    public void move() {
        System.out.println("ship move...");
    }
}
