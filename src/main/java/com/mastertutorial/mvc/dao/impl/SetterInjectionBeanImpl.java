/**
 * 
 */
package com.mastertutorial.mvc.dao.impl;

import com.mastertutorial.mvc.dao.SetterInjectionBean;

/**
 * @author Yashwanth
 *
 */
public class SetterInjectionBeanImpl implements SetterInjectionBean{

	public String message;
	public String name;
	public int id;
	
	public SetterInjectionBeanImpl(){
		
	}
	
	public SetterInjectionBeanImpl(String name) {
		super();
		this.name = name;
		System.out.println("Inside of Injection Bean Constructor");
	}
	
	public SetterInjectionBeanImpl(String name , String message, int id){
		this.name=name;
		this.message=message;
		this.id=id;
	}
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

	public void setMessage(String message) {

		System.out.println("Inside of Setter Injection Bean");
		this.message = message;
	}
	


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	@Override
	public void printMessageWithData(String name, int id, String message) {
		
		System.out.println("printMessageWithData :: Name="
				+name+" Id ="+id+" Message ="+message);
			
	}
}
