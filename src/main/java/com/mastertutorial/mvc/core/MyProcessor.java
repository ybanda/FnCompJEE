/**
 * 
 */
package com.mastertutorial.mvc.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.mastertutorial.mvc.dao.impl.SetterInjectionBeanImpl;

/**
 * @author Yashwanth
 *
 */
public class MyProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(" MyProcessor :: postProcessBeforeInitialization :: "+beanName);
		if(bean instanceof SetterInjectionBeanImpl)
		{
			SetterInjectionBeanImpl obj = (SetterInjectionBeanImpl)bean;
			obj.message="Added from Bean Post Processor";
			return obj;
		}
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(" MyProcessor :: postProcessAfterInitialization ::"+beanName);
		return bean;
	}
	

}
