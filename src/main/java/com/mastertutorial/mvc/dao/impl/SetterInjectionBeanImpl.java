/**
 * 
 */
package com.mastertutorial.mvc.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.mastertutorial.mvc.dao.SetterInjectionBean;

/**
 * @author Yashwanth
 *
 */
public class SetterInjectionBeanImpl implements SetterInjectionBean,BeanNameAware,BeanFactoryAware,ApplicationContextAware{

	private static Logger logger = LoggerFactory.getLogger(SetterInjectionBeanImpl.class);
	public String message;
	public String name;
	public int id;
	private String bname;
	private BeanFactory beanFactory;
	private ApplicationContext ctx;
	
	public SetterInjectionBeanImpl(){
		// This is mandatory as spring will look for 0 param constructor to create the spring bean class object
	}
	
	public SetterInjectionBeanImpl(String name) {
		super();
		this.name = name;
		logger.info("SetterInjectionBeanImpl :: Inside of Injection Bean Constructor");
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

		logger.info("SetterInjectionBeanImpl :: Inside of Setter Injection Bean");
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
		
		logger.info("SetterInjectionBeanImpl :: printMessageWithData :: Name="
				+name+" Id ="+id+" Message ="+message);
			
	}
	
	
	public void printMessage() {
		logger.info(" SetterInjectionBeanImpl :: Current Bean ="+bname
				+"\n Is Singleton ="+ctx.isSingleton(bname)+"\n Is Prototype :: "+ctx.isPrototype(bname)
				+"\n List of beans ::");
	String ids[] = ctx.getBeanDefinitionNames();
	int count =0;
	for(String id :ids) {
		count ++;
		logger.info(count +")"+id);
	}
		logger.info("SetterInjectionBeanImpl :: printMessage :: Name="
				+name+" Id ="+id+" Message ="+message);
			
	}
	
	public void myInit() {
		logger.info(" SetterInjectionBeanImpl :: myInit is called");
		logger.info("Init :: Name="
				+name+" Id ="+id+" Message ="+message);
			
	}
	
	public void myDestroy() {
		logger.info("SetterInjectionBeanImpl :: myDestroy is called");
		id=0;
		message=null;
		name=null;
			
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		logger.info("SetterInjectionBeanImpl :: Inside of setApplicationContext");
		this.ctx=applicationContext;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		logger.info("SetterInjectionBeanImpl :: Inside of Set Bean Factory");
		this.beanFactory=beanFactory;
		
	}

	@Override
	public void setBeanName(String name) {
		logger.info("SetterInjectionBeanImpl :: Inside of set Bean Name");
		this.bname=name;
		
	}
}
