package com.mastertutorial.mvc.model;

public class Customer {

	private String site;
	private String name;
	
	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}
	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void printThrowException() {
		System.out.println(" Exception occured");
		throw new IllegalArgumentException();
	}
	
}
