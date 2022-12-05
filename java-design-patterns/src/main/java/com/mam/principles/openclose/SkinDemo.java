package com.mam.principles.openclose;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 开闭原则
 * 要想再创建其他的皮肤，直接继承skin抽象类
 **/
public class SkinDemo {
    public static void main(String[] args) {
        SouGouInput input = new SouGouInput();
        //DefaultSkin skin = new DefaultSkin();
        DivSkin skin = new DivSkin();
        input.setSkin(skin);
        input.display();
    }
}
