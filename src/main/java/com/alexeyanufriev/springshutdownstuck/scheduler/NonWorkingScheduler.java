package com.alexeyanufriev.springshutdownstuck.scheduler;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledFuture;

@Profile("non-working")
@Service
public class NonWorkingScheduler {

    private final TaskScheduler taskScheduler = new ConcurrentTaskScheduler();

    public NonWorkingScheduler() {
        schedule();
    }

    public void schedule() {
        final ScheduledFuture<?> scheduledFuture = this.taskScheduler.scheduleAtFixedRate(() -> {}, 100);
        System.out.println("scheduled");
        scheduledFuture.cancel(true);
        System.out.println("interrupted");
    }

}
