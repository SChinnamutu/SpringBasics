package com.perf.blog.schedule;

import java.util.Date;


public class Job {
    public void xmlFixedDelayTask() {
        System.out.println(new Date() + " This task runs in fixed delay by xml configuration");
    }

    public void xmlFixedRateTask() {
        System.out.println(new Date() + " This task runs in fixed rate by xml configuration");
    }

    public void xmlCronTask() {
        System.out.println(new Date() + " This task runs in a cron schedule by xml configuration");
    }
}
