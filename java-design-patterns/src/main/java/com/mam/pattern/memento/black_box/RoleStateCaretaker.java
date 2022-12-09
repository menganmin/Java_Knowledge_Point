package com.mam.pattern.memento.black_box;


/**
 * @Author Anmin
 * @Date 2022/12/08
 * 备忘录对象管理对象
 **/
public class RoleStateCaretaker {

    //声明备忘录对象
    private Memento memntor;

    public Memento getMemntor() {
        return memntor;
    }

    public void setMemntor(Memento memntor) {
        this.memntor = memntor;
    }
}
