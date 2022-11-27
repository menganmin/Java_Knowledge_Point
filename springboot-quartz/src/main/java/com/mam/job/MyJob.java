package com.mam.job;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author Anmin
 * @Date 2022/11/27
 **/
@Slf4j
@Component("myJob")
public class MyJob {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void execute(String param) {
        logger.info("执行 MyJob，当前时间：{}，任务参数：{}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), param);
    }
}
