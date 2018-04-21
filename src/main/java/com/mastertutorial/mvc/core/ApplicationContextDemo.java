/**
 * 
 */
package com.mastertutorial.mvc.core;

import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mastertutorial.mvc.dao.AnnotationBean;
import com.mastertutorial.mvc.dao.SetterInjectionBean;
import com.mastertutorial.mvc.dao.impl.AnnotationBeanImpl;
import com.mastertutorial.mvc.dao.impl.DBOperationsDataSourceImpl;
import com.mastertutorial.mvc.dao.impl.SetterInjectionBeanImpl;

/**
 * @author Yashwanth
 *
 */
public class ApplicationContextDemo {

	public static void main(String[] args) {

		String[] cfg = {"appconfig-core.xml","appconfig-core_1.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(cfg);

		SetterInjectionBeanImpl setterInjectionBean = (SetterInjectionBeanImpl)context.getBean("setterInjectionBean");
		System.out.println("Setter Injection Bean Message from Application Context ="+setterInjectionBean.getMessage());

		SetterInjectionBeanImpl constructorInjectionBean = (SetterInjectionBeanImpl)context.getBean("constructorInjectionBean");
		System.out.println("Constructor Injection Bean Message from Application Context ="+constructorInjectionBean.getName());

		SetterInjectionBeanImpl constructorInjectionBeans = (SetterInjectionBeanImpl)context.getBean("constructorInjectionBeans");
		System.out.println("Constructor Injection Beans #3 Message from Application Context Name ="
				+constructorInjectionBeans.getName()+" Id ="+constructorInjectionBeans.getId()+" Message ="+constructorInjectionBeans.getMessage());

		SetterInjectionBean constructorInjectionBeans1 = (SetterInjectionBean)context.getBean("constructorInjectionBeans");
		constructorInjectionBeans1.printMessageWithData("sadasda", 12," Message :: ");
		
		/*AnnotationConfigApplicationContext acontext = new AnnotationConfigApplicationContext();
		acontext.scan("com");
		acontext.refresh();
		AnnotationBeanImpl annotationBean = (AnnotationBeanImpl)acontext.getBean("annotateBean");
		annotationBean.printHelloWithAnnotations();*/

		Date date =(Date)context.getBean("date");
		System.out.println(date.toString());

		DBOperationsDataSourceImpl dbOperations = (DBOperationsDataSourceImpl)context.getBean("dbOperations");
		System.out.println("Course Name = "+dbOperations.fetchCourseName("NodeJS"));
		System.out.println("Course Description = "+dbOperations.fetchCourseDescrption("NodeJS"));
		System.out.println("Course Count = "+dbOperations.fetchTotalCourses());
		System.out.println("Total Records Deleted ="+dbOperations.deleteCourse("BootIcon"));
		dbOperations.addCourse("BootIcon", "Bootstap Icons", "Bootstrap Icons for rich UI");
		dbOperations.updateCourseReturnCount("BootIcon", "Bootstap UI Icons", "Bootstrap 4 Icons for rich UI");

		System.out.println("Table Count ="+dbOperations.getTablecountFromStoreProc("test"));
	
		// I18n Testing
		
		Locale locale = new Locale("fr","CA");
		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext(cfg);
		String msg1= xmlContext.getMessage("Str1", null,"Not Found",locale);
		String msg2= xmlContext.getMessage("Str2", null,"Not Found",locale);
		String msg3= xmlContext.getMessage("Str3", null,"Not Found",locale);
		String msg4= xmlContext.getMessage("Str4", null,"Not Found",locale);
		System.out.println("Message #1="+msg1+", Message #2"+msg2+", Message #3"+msg3+", Message #4"+msg4);
		
		SetterInjectionBeanImpl setterIndexBeans = (SetterInjectionBeanImpl)xmlContext.getBean("constructorInjectionBeansIndexes");
		setterIndexBeans.printMessage();
		xmlContext.close();
		
	}
}
