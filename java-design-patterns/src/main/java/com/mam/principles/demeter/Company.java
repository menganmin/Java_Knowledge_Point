package com.mam.principles.demeter;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 公司类
 **/
public class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
