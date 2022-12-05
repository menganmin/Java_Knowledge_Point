package com.mam.relation.dependence;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 依赖关系
 **/
public class Driver {
    private String name;

    public void ddriver(Car car){
        car.move();
    }
}
