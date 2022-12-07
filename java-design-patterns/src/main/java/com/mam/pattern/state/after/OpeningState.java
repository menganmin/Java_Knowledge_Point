package com.mam.pattern.state.after;


/**
 * @Author Anmin
 * @Date 2022/12/07
 **/
public class OpeningState extends LiftState {
    @Override
    public void open() {
        System.out.println("电梯开启");
    }

    @Override
    public void close() {
        //修改状态
        super.context.setState(Context.CLOSING_STATE);
        //调用当前状态中的context中的close方法
        super.context.close();
    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}
