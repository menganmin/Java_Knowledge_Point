package com.mam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Anmin
 * @Date 2022/11/27
 **/
@SpringBootApplication
@MapperScan("com.mam.dao")
public class TkMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(TkMybatisApplication.class,args);
    }
}
