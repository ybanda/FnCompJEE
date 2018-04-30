/**
 * 
 */
package com.mastertutorial.mvc.batch;

import java.time.LocalTime;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @author Yashwanth
 *
 */
public class BatchExecutionListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Execution before Job :: "+LocalTime.now());
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("Execution after Job :: "+LocalTime.now());
		
		
	}

}
