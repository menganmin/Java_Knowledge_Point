package com.mam.pattern.interpreter;

/**
 * @Author Anmin
 * @Date 2022/12/08
 **/
public class Client {
    public static void main(String[] args) {
        //创建环境对象
        Context context = new Context();

        //创建对各变量对象
        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        Variable d = new Variable("d");

        //将变量存储到环境中
        context.assign(a,1);
        context.assign(b,2);
        context.assign(c,3);
        context.assign(d,4);

        //获取抽象语法树
        AbstractExpression expression = new Minus(a,new Plus(new Minus(b,c),d));

        int result = expression.interpret(context);
        System.out.println(expression + "=" + result);
    }
}
