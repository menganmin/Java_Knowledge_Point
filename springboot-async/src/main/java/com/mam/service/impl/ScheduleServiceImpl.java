package com.mam.service.impl;

import com.mam.service.ScheduleService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author Anmin
 * @Date 2022/11/30
 **/
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Async("asyncTaskExecutor")
    @Scheduled(fixedDelay = 5,timeUnit = TimeUnit.SECONDS)
    @Override
    public void outputMethod() {
        System.out.println("spring 线程池 定时任务");
    }
}
