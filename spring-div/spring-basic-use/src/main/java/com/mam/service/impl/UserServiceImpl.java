package com.mam.service.impl;

import com.mam.dao.UserDao;
import com.mam.service.UserService;

/**
 * @Author Anmin
 * @Date 2022/12/08
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        System.out.println("UserService被创建了");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("UserService....");
        userDao.add();
    }
}
