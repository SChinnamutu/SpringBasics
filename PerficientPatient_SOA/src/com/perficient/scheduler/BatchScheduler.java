package com.perficient.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.perficient.batch.CustomItemReader;

public class BatchScheduler {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	
	@Autowired
	CustomItemReader reader;
	 
	@Scheduled(cron="*/20 * * * * ?")
	public void runJob(){
			reader.addToQueue();
		try {
			JobParameters jobParameters =  new JobParametersBuilder().addLong("time",System.currentTimeMillis()).toJobParameters();
			JobExecution execution = jobLauncher.run(job, jobParameters);
			System.out.println("Job Exit Status : "+ execution.getStatus());
		} catch (JobExecutionException e) {
			System.out.println("Job ExamResult failed");
			e.printStackTrace();
		}
	}
	
}

