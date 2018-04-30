/**
 * 
 */
package com.mastertutorial.mvc.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Yashwanth
 *
 */
public class SpringBatchApp {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("appconfig-batch.xml");
		JobLauncher jobLauncher =(JobLauncher)context.getBean("jobLauncher");
		Job job =(Job)context.getBean("helloSpringBatch");
		JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
		System.out.println("Exit Status :: "+jobExecution.getStatus());
	}
}
