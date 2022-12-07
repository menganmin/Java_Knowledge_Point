package com.mam.pattern.responsibility;

/**
 * @Author Anmin
 * @Date 2022/12/07
 *具体的处理者 -> 部门经理类
 **/
public class Manager extends Handler{

    public Manager(){
        super(Handler.NUM_ONE,Handler.NUM_THREE);
    }


    @Override
    protected void handleLeave(LeaveRequest request) {
        System.out.println(request.getName() + "请假" + request.getNum() + "天，" + "请假内容为：" + request.getContent());
        System.out.println("部门经理审批：同意");
    }
}
