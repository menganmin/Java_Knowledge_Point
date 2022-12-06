package com.mam.pattern.combination;

/**
 * @Author Anmin
 * @Date 2022/12/06
 **/
public class MenuItem extends MenuComponent{

    public MenuItem(String name,int level){
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        for(int i =0;i < level; i++){
            System.out.print("--");
        }
        System.out.println(name);
    }
}
