package com.alexeyanufriev.springshutdownstuck;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration
public class Config implements SmartInitializingSingleton {

    @Override
    public void afterSingletonsInstantiated() {
        throw new NullPointerException("Expected error");
    }

    @Bean
    public Object lockExecutor(TaskScheduler taskScheduler) {
        return null;
    }

}
