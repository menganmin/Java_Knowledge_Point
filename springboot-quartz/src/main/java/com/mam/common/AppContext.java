package com.mam.common;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.Date;

/**
 * @Author Anmin
 * @Date 2022/11/27
 **/
public class AppContext {
    /**
     * 线程本地变量
     */
    public static final TransmittableThreadLocal<Date> threadLocal = new TransmittableThreadLocal<>();

}
