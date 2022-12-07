package com.mam.pattern.template;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 模板方法模式
 **/
public class Client {
    public static void main(String[] args) {
        ConcreteClassBaoCai baoCai = new ConcreteClassBaoCai();
        baoCai.cookProcess();
    }
}
