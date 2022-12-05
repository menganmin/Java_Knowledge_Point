package com.mam.pattern.prototype;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        RealizeType realizeType = new RealizeType();

        RealizeType clone = realizeType.clone();
        System.out.println("原型对象跟克隆出来的是否是同一个对象？" + (realizeType == clone));
    }
}
