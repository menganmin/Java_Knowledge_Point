package com.mam.structures.stack;

import java.util.Scanner;

/**
 * @Author Anmin
 * @Date 2022/12/26
 **/
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        boolean loop = true;
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show：显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：添加数据");
            System.out.println("pop：取出数据");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show" :
                    stack.list();
                    break;
                case "exit" :
                    loop = false;
                    System.out.println("退出程序");
                    scanner.close();
                    break;
                case "push" :
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int result = stack.pop();
                        System.out.println("取出的数据：" +result);
                        break;
                    }catch (Exception e){
                        e.getMessage();
                    }
                default:
                    break;
            }
        }
    }
}

class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//数组，存放数据
    private int top = -1;//栈顶，初始化-1

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
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
}