package com.mam.pattern.state.after;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 抽象状态类
 **/
public abstract class LiftState {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();

}
