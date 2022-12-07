package com.mam.pattern.state.after;


/**
 * @Author Anmin
 * @Date 2022/12/07
 **/
public class StoppingState extends LiftState {
    @Override
    public void open() {
        super.context.setState(Context.OPENING_STATE);
        super.context.open();
    }

    @Override
    public void close() {
        super.context.setState(Context.CLOSING_STATE);
        super.context.close();
    }

    @Override
    public void run() {
        super.context.setState(Context.RUNNING_STATE);
        super.context.run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止了");
    }
}
