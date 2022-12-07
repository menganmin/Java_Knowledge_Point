package com.mam.pattern.state.before;

/**
 * @Author Anmin
 * @Date 2022/12/07
 **/
public class Lift implements ILift{

    private int state;

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        switch(state){
            case OPENING_STATE:
                break;
            case CLOSING_STATE:
                System.out.println("电梯打开了");
                setState(OPENING_STATE);
                break;
            case STOPPING_STATE:
                System.out.println("电梯打开了");
                setState(OPENING_STATE);
                break;
            case RUNNING_STATE:
                break;
        }
    }

    @Override
    public void close() {
        switch(state){
            case OPENING_STATE:
                System.out.println("电梯关闭了");
                setState(CLOSING_STATE);
                break;
            case CLOSING_STATE:
                break;
            case STOPPING_STATE:
                break;
            case RUNNING_STATE:
                System.out.println("电梯关闭了");
                setState(CLOSING_STATE);
                break;
        }
    }

    @Override
    public void run() {
        switch(state){
            case OPENING_STATE:
                break;
            case CLOSING_STATE:
                System.out.println("电梯打开了");
                setState(RUNNING_STATE);
                break;
            case STOPPING_STATE:
                System.out.println("电梯打开了");
                setState(RUNNING_STATE);
                break;
            case RUNNING_STATE:
                break;
        }
    }

    @Override
    public void stop() {
        switch(state){
            case OPENING_STATE:
                System.out.println("电梯关闭了");
                setState(STOPPING_STATE);
                break;
            case CLOSING_STATE:
                break;
            case STOPPING_STATE:
                break;
            case RUNNING_STATE:
                System.out.println("电梯关闭了");
                setState(STOPPING_STATE);
                break;
        }
    }
}
