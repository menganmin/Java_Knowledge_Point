package com.mam.structures.queue;

import java.util.Scanner;

/**
 * @Author Anmin
 * @Date 2022/12/12
 **/
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray arrayQueue = new CircleArray(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加队列");
            System.out.println("g(get):从队列获取数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    arrayQueue.addQueue(scanner.nextInt());
                    break;
                case 'g':
                    try {
                        int i = arrayQueue.getQueue();
                        System.out.println("取出的数据为：" + i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i = arrayQueue.headQueue();
                        System.out.println("头部的数据为：" + i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//创建一个队列类
class CircleArray{
    private int maxSize;//队列最大值
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据

    //创建构造方法
    public CircleArray(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据进数组
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满~");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
       //先把front对应的值保存到变量中
        //将front后移，考虑取模
        //将变量的值返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示数组里面的数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println("下标为" + (i % maxSize)  + "的数据为" + arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("没有数据");
        }
        return arr[front];
    }
}
