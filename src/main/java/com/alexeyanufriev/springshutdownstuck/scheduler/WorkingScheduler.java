package com.alexeyanufriev.springshutdownstuck.scheduler;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledFuture;

@Profile("working")
@Service
public class WorkingScheduler {

    private final TaskScheduler taskScheduler;

    public WorkingScheduler(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
        schedule();
    }

    public void schedule() {
        final ScheduledFuture<?> scheduledFuture = this.taskScheduler.scheduleAtFixedRate(() -> {}, 100);
        System.out.println("scheduled");
        scheduledFuture.cancel(true);
        System.out.println("interrupted");
    }

}
