package com.mam.pattern.interpreter;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 封装变量的类
 **/
public class Variable extends AbstractExpression{

    //声明存储变量名的成员变量
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        return context.getValue(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
