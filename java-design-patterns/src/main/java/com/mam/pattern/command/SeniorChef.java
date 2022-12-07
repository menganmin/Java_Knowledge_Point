package com.mam.pattern.command;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 接收者角色
 **/
public class SeniorChef {

    public void makeFood(String name,int num){
        System.out.println(num + "份" + name + "食物");
    }
}
