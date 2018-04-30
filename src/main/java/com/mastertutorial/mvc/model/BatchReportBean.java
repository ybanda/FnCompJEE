package com.mastertutorial.mvc.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component("beanReport")
public class BatchReportBean {
	private int id;
	private String Impressions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImpressions() {
		return Impressions;
	}

	public void setImpressions(String impressions) {
		Impressions = impressions;
	}

	public void printMessage() {

		System.out.println(LocalDateTime.now()+"BatchReportBean :: printMessage() ");
	}
}
