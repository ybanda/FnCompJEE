/**
 * 
 */
package com.mastertutorial.mvc.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.mastertutorial.mvc.dao.impl.SetterInjectionBeanImpl;

/**
 * @author Yashwanth
 *
 */
public class XMLBeanFactoryDemo {

	private static Logger logger = LoggerFactory.getLogger(XMLBeanFactoryDemo.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("appconfig-core.xml"));
		SetterInjectionBeanImpl setterBean = (SetterInjectionBeanImpl)factory.getBean("setterInjectionBean");
		logger.info("Setter Injection Message from XML Bean Factory Class ="+setterBean.getMessage());
	
	}

}
