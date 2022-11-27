package com.mam.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Anmin
 * @Date 2022/11/27
 **/
@Data
@ApiModel(description = "User实体Vo")
public class UserVo {
    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("用户地址")
    private String address;
}
