package com.mam.pattern.memento.white_box;

/**
 * @Author Anmin
 * @Date 2022/12/08
 **/
public class Client {
    public static void main(String[] args) {
        System.out.println("大战BOSS前=========");
        GameRole gameRole = new GameRole();
        gameRole.initState();//初始化状态
        gameRole.stateDisplay();

        //将该游戏进行备份
        //创建管理者对象
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setRoleStateMemntor(gameRole.saveState());
        System.out.println("大战BOSS之后===========");

        //发生损耗
        gameRole.fight();
        gameRole.stateDisplay();

        System.out.println("恢复之前的状态===========");
        gameRole.recoverState(roleStateCaretaker.getRoleStateMemntor());
        gameRole.stateDisplay();
    }
}
