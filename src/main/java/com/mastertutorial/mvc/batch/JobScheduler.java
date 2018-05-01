/**
 * 
 */
package com.mastertutorial.mvc.batch;

import java.time.LocalDateTime;

import javax.batch.runtime.JobExecution;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Yashwanth
 *
 */
//@Component
public class JobScheduler {

	//@Autowired
	private JobLauncher jobLauncher;

	//@Autowired
	private Job job;

	public void run() {
		try {
			LocalDateTime dateTime = LocalDateTime.now();
			JobParameters parameters = new JobParametersBuilder()
					.addString("date", dateTime.toString()).toJobParameters();
			System.out.println(" DateTime ="+dateTime.toString());

			org.springframework.batch.core.JobExecution execution = jobLauncher.run(job, parameters);

			System.out.println(" Exit Status :: "+execution.getStatus());
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
}
