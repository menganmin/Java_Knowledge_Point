package com.mam.controller;

import com.mam.framework.context.ApplicationContext;
import com.mam.framework.context.support.ClassPathXmlApplicationContext;
import com.mam.service.UserService;

/**
 * @Author Anmin
 * @Date 2022/12/08
 **/
public class UserController {
    public static void main(String[] args) throws Exception {
        //创建spring的容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");//启动程序，立刻加载bean对象
        //BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));//延时加载
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.add();
    }
}
