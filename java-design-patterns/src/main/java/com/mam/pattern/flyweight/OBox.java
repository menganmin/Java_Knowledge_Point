package com.mam.pattern.flyweight;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 具体享元角色
 **/
public class OBox extends AbstractBox{
    @Override
    public String getShape() {
        return "O";
    }
}
