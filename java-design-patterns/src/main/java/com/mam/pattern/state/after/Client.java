package com.mam.pattern.state.after;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 状态模式
 **/
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new RunningState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
