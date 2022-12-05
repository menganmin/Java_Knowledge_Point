package com.mam.principles.demeter;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class AgentDemo {
    public static void main(String[] args) {
        Agent agent = new Agent();
        Star star = new Star("小敏哥");
        Fans fans = new Fans("小老弟");
        Company company = new Company("喜之郎");
        agent.setCompany(company);
        agent.setStar(star);
        agent.setFans(fans);
        agent.meeting();
        agent.business();
    }
}
