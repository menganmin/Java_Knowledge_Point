package com.mam.principles.richter.after;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 正方形
 **/
public class Square implements Quadrilateral{
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getLength() {
        return side;
    }

    @Override
    public double getWidth() {
        return side;
    }
}
