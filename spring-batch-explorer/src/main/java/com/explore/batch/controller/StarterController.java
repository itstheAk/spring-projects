package com.explore.batch.controller;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/load")
public class StarterController {
	
	@Autowired
	JobLauncher launcher;
	
	@Autowired
	Job job;
	
	@GetMapping
	public BatchStatus doLoad() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		JobParameters jobParams = new JobParameters();
		System.out.println("About to launch Job");
		JobExecution jobExecution =  launcher.run(job, jobParams);
		System.out.println("Job started");
		while(jobExecution.isRunning()) {
			System.out.print("->");
		}
		System.out.println("Job done");
		return jobExecution.getStatus();
	}

}
