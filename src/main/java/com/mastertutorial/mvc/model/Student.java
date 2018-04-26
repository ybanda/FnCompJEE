package com.mastertutorial.mvc.model;

public class Student {

	private Integer age;
	private String name;
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
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
