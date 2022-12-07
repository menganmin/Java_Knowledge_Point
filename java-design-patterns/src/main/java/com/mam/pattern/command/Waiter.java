package com.mam.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Anmin
 * @Date 2022/12/07
 * 请求者角色
 **/
public class Waiter {

    //持有多个命令对象
    private List<Command> commands = new ArrayList<>();

    public void setCmd(Command cmd){
        commands.add(cmd);
    }

    //服务员发起命令
    public void orderUp(){
        System.out.println("订单来了");
        for (Command command : commands) {
            if(command != null){
                command.execute();
            }
        }
    }
}
