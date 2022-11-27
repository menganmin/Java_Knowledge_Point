package com.mam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Anmin
 * @Date 2022/11/27
 **/
@SpringBootApplication
@MapperScan("com.mam.mapper")
public class ReverseMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReverseMybatisApplication.class,args);
    }
}
