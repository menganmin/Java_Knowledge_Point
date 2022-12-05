package com.mam.principles.demeter;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 明星类
 **/
public class Star {
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
