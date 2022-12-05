package com.mam.principles.richter.after;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 里氏代换原则
 **/
public class RectangleDemo {
    public static void main(String[] args) {
        //创建长方形对象
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(20);
        rectangle.setWidth(10);
        resize(rectangle);
        printLengthAndWidth(rectangle);
    }

    //扩宽的方法
    public static void resize(Rectangle rectangle){
        //判断宽如果比长小，进行扩宽的操作
        while (rectangle.getWidth() <= rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    //打印长和宽
    public static void printLengthAndWidth(Quadrilateral quadrilateral){
        System.out.println("长："+quadrilateral.getLength());
        System.out.println("宽："+quadrilateral.getWidth());
    }

}
