package com.mam.pattern.responsibility;

/**
 * @Author Anmin
 * @Date 2022/12/07
 *具体的处理者 -> 总经理类
 **/
public class GeneralManager extends Handler{

    public GeneralManager(){
        super(Handler.NUM_THREE,Handler.NUM_SEVEN);
    }


    @Override
    protected void handleLeave(LeaveRequest request) {
        System.out.println(request.getName() + "请假" + request.getNum() + "天，" + "请假内容为：" + request.getContent());
        System.out.println("总经理审批：同意");
    }
}
