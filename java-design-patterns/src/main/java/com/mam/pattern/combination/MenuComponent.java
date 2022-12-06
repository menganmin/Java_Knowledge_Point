package com.mam.pattern.combination;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 抽象根节点 -> 菜单组件
 **/
public abstract class MenuComponent {
    //菜单组件名称
    protected String name;
    //菜单组件层级
    protected int level;

    //添加子菜单
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }
    //移除子菜单
    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }
    //获取指定的子菜单
    public MenuComponent getChild(int index){
        throw new UnsupportedOperationException();
    }
    //获取菜单或者菜单项的名称
    public String getName(){
        return name;
    }
    //打印菜单名称的方法
    public abstract void print();
}
