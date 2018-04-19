/**
 * 
 */
package com.mastertutorial.mvc.core;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Yashwanth
 *
 */
public class XMLBeanFactoryDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("appconfig-core.xml"));
		SetterInjectionBeanImpl setterBean = (SetterInjectionBeanImpl)factory.getBean("setterInjectionBean");
		System.out.println("Setter Injection Message from XML Bean Factory Class ="+setterBean.getMessage());
	
	}

}
