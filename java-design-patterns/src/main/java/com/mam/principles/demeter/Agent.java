package com.mam.principles.demeter;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 经纪人类
 **/
public class Agent {

    private Company company;
    private Fans fans;
    private Star star;

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    //和粉丝见面
    public void meeting(){
        System.out.println(star.getName() + "和粉丝" + fans.getName() + "见面了");
    }
    //和媒体公司洽谈
    public void business(){
        System.out.println(star.getName() + "和公司" + company.getName() + "洽谈了");
    }
}
