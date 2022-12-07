package com.mam.pattern.state.after;


/**
 * @Author Anmin
 * @Date 2022/12/07
 **/
public class RunningState extends LiftState {
    @Override
    public void open() {
        
    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        System.out.println("电梯正在运行");
    }

    @Override
    public void stop() {
        super.context.setState(Context.STOPPING_STATE);
        super.context.stop();
    }
}
