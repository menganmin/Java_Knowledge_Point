package com.mam.pattern.interpreter;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 抽象表达式类
 **/
public abstract class AbstractExpression {

    public abstract int interpret(Context context);
}
