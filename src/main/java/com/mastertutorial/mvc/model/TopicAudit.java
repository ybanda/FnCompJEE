/**
 * 
 */
package com.mastertutorial.mvc.model;

import java.sql.Date;

/**
 * @author Yashwanth
 *
 */
public class TopicAudit {

	int id;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the topicId
	 */
	public String getTopicId() {
		return topicId;
	}
	/**
	 * @param topicId the topicId to set
	 */
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	/**
	 * @return the date_updated_ts
	 */
	public Date getDate_updated_ts() {
		return date_updated_ts;
	}
	/**
	 * @param date_updated_ts the date_updated_ts to set
	 */
	public void setDate_updated_ts(Date date_updated_ts) {
		this.date_updated_ts = date_updated_ts;
	}
	/**
	 * @return the action
	 */
	public String getActions() {
		return actions;
	}
	/**
	 * @param action the action to set
	 */
	public void setActions(String actions) {
		this.actions = actions;
	}
	String topicId;
	Date date_updated_ts;
	String actions;
}
