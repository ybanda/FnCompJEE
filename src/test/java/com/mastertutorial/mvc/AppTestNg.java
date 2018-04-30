/**
 * 
 */
package com.mastertutorial.mvc;

import javax.batch.runtime.BatchStatus;

import org.junit.Test;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

/**
 * @author Yashwanth
 *
 */
@ContextConfiguration(locations= {
		"classpath:appconfig-test.xml",
		"classpath:appconfig-quartz-batch.xml"
		
		})
public class AppTestNg extends AbstractTestNGSpringContextTests{

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Test
	public void launchJob() throws Exception{
		
		org.springframework.batch.core.JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		//JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1");
		Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
		
	}

	/**
	 * @return the jobLauncherTestUtils
	 */
	public JobLauncherTestUtils getJobLauncherTestUtils() {
		return jobLauncherTestUtils;
	}

	/**
	 * @param jobLauncherTestUtils the jobLauncherTestUtils to set
	 */
	public void setJobLauncherTestUtils(JobLauncherTestUtils jobLauncherTestUtils) {
		this.jobLauncherTestUtils = jobLauncherTestUtils;
	}
}
