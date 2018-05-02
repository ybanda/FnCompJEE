package com.mastertutorial.mvc.model;

import java.io.Serializable;

public class Product implements Serializable {
	
	private String name;
	private double price;
	
	public Product(String name,double price)
	{
		this.name=name;this.price=price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	

}
