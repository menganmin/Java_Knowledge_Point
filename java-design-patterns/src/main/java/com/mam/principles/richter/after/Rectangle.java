package com.mam.principles.richter.after;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class Rectangle implements Quadrilateral{
    private double length;
    private double width;

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }
}
