package com.mam.mybatis;

import com.mam.mybatis.entity.User;
import com.mam.mybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author Anmin
 * @Date 2022/11/27
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void selectAllUser(){
        List<User> users = userMapper.selectAllUser();
        users.stream().forEach(user -> System.out.println(user.getId()));
    }
}
