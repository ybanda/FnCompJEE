package com.mastertutorial.mvc;

import static org.junit.Assert.assertEquals;

import javax.batch.runtime.BatchStatus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"classpath:appconfig-quartz-batch.xml",
		"classpath:appconfig-test.xml"
		})
public class AppTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Test
	public void launchJob() throws Exception{
		
		org.springframework.batch.core.JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		//JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1");
		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
		
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
