/**
 * 
 */
package com.mastertutorial.mvc.core;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Yashwanth
 *
 */
public class ApplicationContextDemo {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("appconfig-core.xml");

		SetterInjectionBeanImpl setterInjectionBean = (SetterInjectionBeanImpl)context.getBean("setterInjectionBean");
		System.out.println("Setter Injection Bean Message from Application Context ="+setterInjectionBean.getMessage());

		SetterInjectionBeanImpl constructorInjectionBean = (SetterInjectionBeanImpl)context.getBean("constructorInjectionBean");
		System.out.println("Constructor Injection Bean Message from Application Context ="+constructorInjectionBean.getName());

		SetterInjectionBeanImpl constructorInjectionBeans = (SetterInjectionBeanImpl)context.getBean("constructorInjectionBeans");
		System.out.println("Constructor Injection Beans #3 Message from Application Context Name ="
				+constructorInjectionBeans.getName()+" Id ="+constructorInjectionBeans.getId()+" Message ="+constructorInjectionBeans.getMessage());

		SetterInjectionBean constructorInjectionBeans1 = (SetterInjectionBean)context.getBean("constructorInjectionBeans");
		constructorInjectionBeans1.printMessageWithData("sadasda", 12," Message :: ");

		Date date =(Date)context.getBean("date");
		System.out.println(date.toString());

	}
}
