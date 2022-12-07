package com.mam.pattern.flyweight.typical;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * Integer运用到了享元模式
 **/
public class IntegerDemo {
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println("i1和i2是否是同一个对象： " + (i1 == i2));

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println("i3和i4是否是同一个对象： " + (i3 == i4));
    }
}
