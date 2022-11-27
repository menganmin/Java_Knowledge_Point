package com.mam.mybatis.mapper;

import com.mam.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Anmin
 * @Date 2022/11/27
 **/
@Mapper
@Component
public interface UserMapper {

    @Select("select * from orm_user")
    public List<User> selectAllUser();

    @Select("select * from orm_user where id = #{id}")
    public User selectUserById(@Param("id") Long id);
}
