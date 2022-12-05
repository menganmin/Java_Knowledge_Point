package com.mam.principles.openclose;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class SouGouInput {
    //聚合关系
    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display(){
        skin.display();
    }
}
