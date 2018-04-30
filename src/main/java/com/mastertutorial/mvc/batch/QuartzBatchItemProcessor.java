package com.mastertutorial.mvc.batch;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.mastertutorial.mvc.model.BatchReportBean;

public class QuartzBatchItemProcessor extends QuartzJobBean{

	private BatchReportBean beanReport;
	
	/**
	 * @return the beanReport
	 */
	public BatchReportBean getBeanReport() {
		return beanReport;
	}

	/**
	 * @param beanReport the beanReport to set
	 */
	public void setBeanReport(BatchReportBean beanReport) {
		this.beanReport = beanReport;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		beanReport.printMessage();
		
	}

	
	

}
