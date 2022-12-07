package com.mam.pattern.responsibility;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 请假条类，发起点
 **/
public class LeaveRequest {
    //姓名
    private String name;
    //请教天数
    private int num;
    //请假内容
    private String content;

    public LeaveRequest(String name, int num, String content) {
        this.name = name;
        this.num = num;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
