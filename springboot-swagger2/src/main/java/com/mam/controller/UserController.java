package com.mam.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Anmin
 * @Date 2022/11/27
 **/
@RestController
@RequestMapping("/user")
@Api(tags="user模块")
public class UserController {

    @ApiOperation(value = "根据id查询用户信息", notes = "查询数据库中某个的用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path",dataType="int", required = true)
    @GetMapping("get/{id}")
    public String getUserById(@PathVariable Integer id) {
        if(id == 0){
            return "查无此人";
        }else{
            return "{\"id\":\""+id+"\",\"userName\":\"小老弟\",\"address\":\"南宁\"}";
        }
    }
}
