package com.mastertutorial.mvc.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component("report")
public class BatchReport {
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
		System.out.println(LocalDateTime.now()+"BatchReport :: printMessage()");
	}
}
