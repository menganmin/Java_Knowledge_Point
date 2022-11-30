package com.mam.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Author Anmin
 * @Date 2022/11/30
 * 定义线程池
 **/
@Configuration
@Slf4j
public class AsyncConfig {
    @Value("${executor.core}")
    private String corePool;

    @Value("${executor.maxpool}")
    private String maxPool;

    @Bean("asyncTaskExecutor")
    public AsyncTaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor asyncTaskExecutor = new ThreadPoolTaskExecutor();
        asyncTaskExecutor.setMaxPoolSize(Integer.parseInt(maxPool));
        asyncTaskExecutor.setCorePoolSize(Integer.parseInt(corePool));
        asyncTaskExecutor.setThreadNamePrefix("async-task-thread-pool-");
        asyncTaskExecutor.setRejectedExecutionHandler((runnable, threadPoolExecutor)
                -> log.warn("thread-pool is full"));
        asyncTaskExecutor.initialize();
        return asyncTaskExecutor;
    }

}
