package com.mam.pattern.memento.white_box;

/**
 * @Author Anmin
 * @Date 2022/12/08
 * 备忘录对象管理对象
 **/
public class RoleStateCaretaker {

    //声明备忘录对象
    private RoleStateMemntor roleStateMemntor;

    public RoleStateMemntor getRoleStateMemntor() {
        return roleStateMemntor;
    }

    public void setRoleStateMemntor(RoleStateMemntor roleStateMemntor) {
        this.roleStateMemntor = roleStateMemntor;
    }
}
