package com.mam.pattern.state.before;

/**
 * @Author Anmin
 * @Date 2022/12/07
 **/
public class Client {
    public static void main(String[] args) {
        Lift lift = new Lift();
        lift.setState(ILift.OPENING_STATE);
        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }
}
