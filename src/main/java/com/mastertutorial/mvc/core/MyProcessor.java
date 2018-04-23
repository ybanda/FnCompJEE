/**
 * 
 */
package com.mastertutorial.mvc.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.mastertutorial.mvc.dao.impl.SetterInjectionBeanImpl;

/**
 * @author Yashwanth
 *
 */
public class MyProcessor implements BeanPostProcessor{
private static Logger logger = LoggerFactory.getLogger(MyProcessor.class);
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.info(" MyProcessor :: postProcessBeforeInitialization :: "+beanName);
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
		logger.info(" MyProcessor :: postProcessAfterInitialization ::"+beanName);
		return bean;
	}
	

}
