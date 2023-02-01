package com.mam.structures.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author Anmin
 * @Date 2022/12/27
 **/
public class PolandNotation {
    public static void main(String[] args) {
        /*//(3+4)*5-6 => 3 4 + 5 * 6
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        int value = calculate(list);
        System.out.println("计算的结果是：" + value);*/

        String expression = "1+((2+3)*4)-5";
        List<String> inFixExpression = toInFixExpression(expression);
        System.out.println("中缀表达式 = "+inFixExpression);

        List<String> suffixExpression = parseSuffixExpressionList(inFixExpression);
        System.out.println("后缀表达式 = "+suffixExpression);

        int value = calculate(suffixExpression);
        System.out.println("最终结果为 = "+value);
    }

    public static List<String> parseSuffixExpressionList(List<String> list){
        Stack<String> s1 = new Stack<>();
        ArrayList<String> s2 = new ArrayList<>();
        for (String item : list) {
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //如果是右括号，依次弹出s1栈顶的运算符，压入到s2，直到遇到左括号为止，此时将一对括号丢弃
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else{
                //当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出，并加入到s2
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出加入s2中
        while (s1.size() != 0 ){
            s2.add(s1.pop());
        }
        return s2;
    }

    //将中缀表达式转成对应的List
    public static List<String> toInFixExpression(String s){
        //定义一个list，存放中缀表达式对应的内容
        List<String> list = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do{
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                list.add("" + c);
                i++;
            }else{
                str = "";
                while (i<s.length() && (c = s.charAt(i))>=48 && (c = s.charAt(i)) <=57){
                    str +=c;
                    i++;
                }
                list.add(str);
            }
        }while (i<s.length());
        return list;
    }

    public static List<String> getListString(String suffixExpression){
        List<String> list = new ArrayList<>();
        Arrays.stream(suffixExpression.split(" "))
                .forEach(express -> list.add(express));
        return list;
    }

    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if(item.matches("\\d+")){
                stack.push(item);
            }else{
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result = 0;
                switch (item){
                    case "+":
                        result =  num1 + num2;
                        break;
                    case "-":
                        result =  num2 - num1;
                        break;
                    case "*":
                        result =  num1 * num2;
                        break;
                    case "/":
                        result =  num1 / num2;
                        break;
                    default:
                        break;
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

class Operation{
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}
