package com.mam.dao.impl;

import com.mam.dao.UserDao;

/**
 * @Author Anmin
 * @Date 2022/12/08
 **/
public class UserDaoImpl implements UserDao {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void add() {
        System.out.println("UserDao..." + username + ":" + password);
    }
}
