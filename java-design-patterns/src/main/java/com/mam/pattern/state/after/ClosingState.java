package com.mam.pattern.state.after;


/**
 * @Author Anmin
 * @Date 2022/12/07
 **/
public class ClosingState extends LiftState {
    @Override
    public void open() {
        super.context.setState(Context.OPENING_STATE);
        super.context.open();
    }

    @Override
    public void close() {
        System.out.println("电梯关闭了");
    }

    @Override
    public void run() {
        super.context.setState(Context.RUNNING_STATE);
        super.context.run();
    }

    @Override
    public void stop() {
        super.context.setState(Context.STOPPING_STATE);
        super.context.stop();
    }
}
