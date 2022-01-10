package com.alexeyanufriev.springshutdownstuck;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@EnableScheduling
@Configuration
public class Config implements SmartInitializingSingleton {

    @Override
    public void afterSingletonsInstantiated() {
        throw new NullPointerException("Expected error");
    }

    @Bean
    @Profile("non-working")
    public TaskScheduler scheduler() {
        return new ConcurrentTaskScheduler();
    }

    @Bean
    public Object lockExecutor(TaskScheduler taskScheduler) {
        return null;
    }

}
