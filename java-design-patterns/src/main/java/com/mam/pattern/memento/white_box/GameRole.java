package com.mam.pattern.memento.white_box;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 发起人角色 -> 游戏角色类
 **/
public class GameRole {

    private int vit;//生命力
    private int atk;//攻击力
    private int def;//防御力

    //初始化内部状态
    public void initState(){
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    //战斗
    public void fight(){
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    //保存角色状态功能
    public RoleStateMemntor saveState(){
        return new RoleStateMemntor(vit,atk,def);
    }

    //从备忘录拿取保存的状态
    public void recoverState(RoleStateMemntor roleStateMemntor){
        this.vit = roleStateMemntor.getVit();
        this.atk = roleStateMemntor.getAtk();
        this.def = roleStateMemntor.getDef();
    }

    //展示状态
    public void stateDisplay(){
        System.out.println("攻击力：" + atk);
        System.out.println("生命力：" + vit);
        System.out.println("防御力：" + def);
    }
    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
