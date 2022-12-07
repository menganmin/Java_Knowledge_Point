package com.mam.pattern.responsibility;

/**
 * @Author Anmin
 * @Date 2022/12/07
 *具体的处理者 -> 小组长类
 **/
public class GroupLeader extends Handler{

    public GroupLeader(){
        super(0,Handler.NUM_ONE);
    }


    @Override
    protected void handleLeave(LeaveRequest request) {
        System.out.println(request.getName() + "请假" + request.getNum() + "天，" + "请假内容为：" + request.getContent());
        System.out.println("小组长审批：同意");
    }
}
