package com.mam.pattern.builder.demo2;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 采用建造者模式，构建复杂的对象，对有参构造进行解耦
 **/
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cup("Intel")
                .memory("内存条")
                .screen("三星")
                .mainboard("华硕")
                .builder();
        System.out.println(phone);
    }
}
