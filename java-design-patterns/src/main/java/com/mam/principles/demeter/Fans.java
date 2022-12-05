package com.mam.principles.demeter;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 粉丝类
 **/
public class Fans {
    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
