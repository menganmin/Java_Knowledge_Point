package com.mam.pattern.responsibility;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 抽象处理者
 **/
public abstract class Handler {

    protected static final int NUM_ONE = 1;
    protected static final int NUM_THREE = 3;
    protected static final int NUM_SEVEN = 7;

    //该领导处理的请求天数区间
    private int startNum;
    private int endNum;
    //声明后续者（上级领导）
    private Handler nextHandler;

    public Handler(int startNum) {
        this.startNum = startNum;
    }

    public Handler(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }
    //设置上级领导对象
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    //各级领导处理请假条的方法
    protected abstract void handleLeave(LeaveRequest request);

    //提交请假条
    //统一规范子类不能重写该方法
    public final void submit(LeaveRequest request){
        //该领导进行审批
        this.handleLeave(request);
        if(this.nextHandler != null && request.getNum() > this.endNum){
            this.nextHandler.submit(request);
        }else{
            System.out.println("流程结束");
        }
    }
}
