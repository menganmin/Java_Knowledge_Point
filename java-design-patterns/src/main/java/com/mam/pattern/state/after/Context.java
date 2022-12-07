package com.mam.pattern.state.after;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 环境角色类
 **/
public class Context {

    //定义对应当前状态对象的常量
    public static final OpeningState OPENING_STATE = new OpeningState();
    public static final ClosingState CLOSING_STATE = new ClosingState();
    public static final RunningState RUNNING_STATE = new RunningState();
    public static final StoppingState STOPPING_STATE = new StoppingState();

    //定义一个当前电梯状态变量
    private LiftState state;

    public LiftState getState() {
        return state;
    }

    public void setState(LiftState state) {
        this.state = state;
        //设置当前状态对象中的context对象
        this.state.setContext(this);
    }

    public void open(){
        state.open();
    }
    public void close(){
        state.close();
    }
    public void run(){
        state.run();
    }
    public void stop(){
        state.stop();
    }
}
