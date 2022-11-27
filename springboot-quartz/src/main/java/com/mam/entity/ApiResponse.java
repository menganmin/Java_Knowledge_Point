package com.mam.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Anmin
 * @Date 2022/11/27
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> implements Serializable {

    @ApiModelProperty(value = "状态，0-成功，1-失败")
    private int code;

    @ApiModelProperty(value = "信息")
    private String msg;

    @ApiModelProperty(value = "数据体")
    private T data;

    /**
     * 失败，不带错误信息
     */
    public static ApiResponse<Object> error(String msg) {
        return new ApiResponse<>(1, msg, null);
    }

    /**
     * 失败，不带错误信息
     */
    public static ApiResponse<Object> error() {
        return new ApiResponse<>(1, null, null);
    }

    /**
     * 成功，不带返回数据
     */
    public static ApiResponse<Object> success(String msg) {
        return new ApiResponse<>(0, msg, null);
    }

    /**
     * 成功，不带返回数据
     */
    public static ApiResponse<Object> success() {
        return new ApiResponse<>(0, "请求成功", null);
    }
}
