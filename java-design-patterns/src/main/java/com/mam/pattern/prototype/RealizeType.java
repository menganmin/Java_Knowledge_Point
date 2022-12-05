package com.mam.pattern.prototype;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class RealizeType implements Cloneable{
    public RealizeType(){
        System.out.println("创建对象");
    }

    @Override
    protected RealizeType clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功");
        return (RealizeType) super.clone();
    }
}
