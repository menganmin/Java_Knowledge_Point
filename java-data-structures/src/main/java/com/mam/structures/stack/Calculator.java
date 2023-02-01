package com.mam.structures.stack;

/**
 * @Author Anmin
 * @Date 2022/12/26
 **/
public class Calculator {
    public static void main(String[] args) {

        String expression = "70+2*6-4";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true){
            ch = expression.substring(index, index + 1).charAt(0);
            if(operStack.isOper(ch)){//如果是操作符
                //判断当前符号栈是否为空
                if(!operStack.isEmpty()){
                    //如果当前的操作符的优先级小于或者等于栈中的操作符，需要pop两个数进行计算
                    //然后将得到的结果在push到栈中，将当前的符号也push到栈中
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算结果入栈
                        numStack.push(res);
                        //把当前的符号入栈
                        operStack.push(ch);
                    }else{
                        //如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                }else{
                    operStack.push(ch);
                }
            }else{
                keepNum += ch;
                if(index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if(index >= expression.length()){
                break;
            }
        }

        while (true){
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.println("表达式" + expression +" = " + numStack.pop());
    }
}
class ArrayStack2{
    private int maxSize;//栈的大小
    private int[] stack;//数组，存放数据
    private int top = -1;//栈顶，初始化-1

    public ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public int peek(){
        return stack[top];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        if (isEmpty()){
            throw  new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈
    public void list(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("栈元素：" + stack[i]);
        }
    }

    //定义符号优先级
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else{
            return -1;
        }
    }

    //判断是否为运算符
    public boolean isOper(char val){
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int result = 0;
        switch (oper){
            case '+':
                result =  num1 + num2;
                break;
            case '-':
                result =  num2 - num1;
                break;
            case '*':
                result =  num1 * num2;
                break;
            case '/':
                result =  num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }
}
