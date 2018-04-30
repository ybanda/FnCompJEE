/**
 * 
 */
package com.mastertutorial.mvc.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Yashwanth
 *
 */
@XmlRootElement(name="BatchResult")
public class BatchResult {


	private String batchName;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	

	private String batchId;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BatchResult [batchName=" + batchName + ", batchId=" + batchId + ", processingTime=" + processingTime
				+ ", datets=" + datets + "]";
	}
	private String processingTime;
	
	private String datets;

	/**
	 * @return the datets
	 */
	public String getDatets() {
		return datets;
	}
	/**
	 * @param datets the datets to set
	 */

	@XmlElement(name="datets")
	public void setDatets(String datets) {
		this.datets = datets;
	}
	/**
	 * @return the batchName
	 */
	public String getBatchName() {
		return batchName;
	}
	/**
	 * @param batchName the batchName to set
	 */
	@XmlElement(name="batchName")
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	/**
	 * @return the batchId
	 */
	public String getBatchId() {
		return batchId;
	}
	/**
	 * @param batchId the batchId to set
	 */
	@XmlElement(name="batchId")
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	/**
	 * @return the processingTime
	 */
	public String getProcessingTime() {
		return processingTime;
	}
	/**
	 * @param processingTime the processingTime to set
	 */

	@XmlElement(name="processingTime")
	public void setProcessingTime(String processingTime) {
		this.processingTime = processingTime;
	}
	
	
}
