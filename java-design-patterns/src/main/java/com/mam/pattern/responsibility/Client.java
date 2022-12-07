package com.mam.pattern.responsibility;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 责任链模式
 **/
public class Client {
    public static void main(String[] args) {
        //创建请教条对象
        LeaveRequest leave = new LeaveRequest("小白",1,"想出去吃螺蛳粉");

        //创建各级领导对象
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();
        //设置链路关系
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        //提交申请
        groupLeader.submit(leave);
    }
}
