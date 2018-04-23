/**
 * 
 */
package com.mastertutorial.mvc.core;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mastertutorial.mvc.dao.SetterInjectionBean;
import com.mastertutorial.mvc.dao.impl.DBOperationsDataSourceImpl;
import com.mastertutorial.mvc.dao.impl.SetterInjectionBeanImpl;
import com.mastertutorial.mvc.dao.impl.TopicAuditAnnotateImpl;
import com.mastertutorial.mvc.mail.SendEmailImpl;
import com.mastertutorial.mvc.dao.impl.TopicAuditImpl;

/**
 * @author Yashwanth
 *
// */
/*@ComponentScan(basePackages= {"com.mastertutorial.mvc.dao.impl"})*/
public class ApplicationContextDemo {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationContextDemo.class);

	public static void main(String[] args) {

		String[] cfg = {"appconfig-core.xml","appconfig-core_1.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(cfg);

		SetterInjectionBeanImpl setterInjectionBean = (SetterInjectionBeanImpl)context.getBean("setterInjectionBean");
		logger.info("Setter Injection Bean Message from Application Context ="+setterInjectionBean.getMessage());

		SetterInjectionBeanImpl constructorInjectionBean = (SetterInjectionBeanImpl)context.getBean("constructorInjectionBean");
		logger.info("Constructor Injection Bean Message from Application Context ="+constructorInjectionBean.getName());

		SetterInjectionBeanImpl constructorInjectionBeans = (SetterInjectionBeanImpl)context.getBean("constructorInjectionBeans");
		logger.info("Constructor Injection Beans #3 Message from Application Context Name ="
				+constructorInjectionBeans.getName()+" Id ="+constructorInjectionBeans.getId()+" Message ="+constructorInjectionBeans.getMessage());

		SetterInjectionBean constructorInjectionBeans1 = (SetterInjectionBean)context.getBean("constructorInjectionBeans");
		constructorInjectionBeans1.printMessageWithData("sadasda", 12," Message :: ");

		/*AnnotationConfigApplicationContext acontext = new AnnotationConfigApplicationContext();
		acontext.scan("com");
		acontext.refresh();
		AnnotationBeanImpl annotationBean = (AnnotationBeanImpl)acontext.getBean("annotateBean");
		annotationBean.printHelloWithAnnotations();*/

		Date date =(Date)context.getBean("date");
		logger.info(date.toString());

		DBOperationsDataSourceImpl dbOperations = (DBOperationsDataSourceImpl)context.getBean("dbOperations");
		logger.info("Course Name = "+dbOperations.fetchCourseName("NodeJS"));
		logger.info("Course Description = "+dbOperations.fetchCourseDescrption("NodeJS"));
		logger.info("Course Count = "+dbOperations.fetchTotalCourses());
		logger.info("Total Records Deleted ="+dbOperations.deleteCourse("BootIcon"));
		dbOperations.addCourse("BootIcon", "Bootstap Icons", "Bootstrap Icons for rich UI",false);
		dbOperations.updateCourseReturnCount("BootIcon", "Bootstap UI Icons", "Bootstrap 4 Icons for rich UI",false);



		logger.info("Total Records Deleted ="+dbOperations.deleteCourse("Scala2"));
		DBOperationsDataSourceImpl dbOperationsJT = (DBOperationsDataSourceImpl)context.getBean("dbOperationsJT");
		dbOperationsJT.addCourse("Scala2", "Scala Framework2", "Scala , A Java based Framework2",true);
		logger.info("Table Count ="+dbOperations.getTablecountFromStoreProc("test"));

		// I18n Testing

		Locale locale = new Locale("fr","CA");
		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext(cfg);
		String msg1= xmlContext.getMessage("Str1", null,"Not Found",locale);
		String msg2= xmlContext.getMessage("Str2", null,"Not Found",locale);
		String msg3= xmlContext.getMessage("Str3", null,"Not Found",locale);
		String msg4= xmlContext.getMessage("Str4", null,"Not Found",locale);
		logger.info("Message #1="+msg1+", Message #2"+msg2+", Message #3"+msg3+", Message #4"+msg4);

		SetterInjectionBeanImpl setterIndexBeans = (SetterInjectionBeanImpl)xmlContext.getBean("constructorInjectionBeansIndexes");
		setterIndexBeans.printMessage();

		TopicAuditImpl topicAudit = (TopicAuditImpl)context.getBean("hbmTopicAudit");
		for(com.mastertutorial.mvc.model.TopicAudit audit:topicAudit.getData()) {
			logger.info(" Topic details :: Id :: "+audit.getId() +"\t :: Topic Id :: "+audit.getTopicId()+" \t :: Topic Date :: "+audit.getDate_updated_ts()
			+"\t Topic Date Updated :: "+audit.getDate_updated_ts().toString() );

		}
		logger.info(" ------------------------Hibernate With Annotations --------------------------------");

		TopicAuditAnnotateImpl topicAnnotate = (TopicAuditAnnotateImpl)context.getBean("topicAuditAnnotate");
		for(com.mastertutorial.mvc.model.TopicAuditAnnotate audit:topicAnnotate.getData()) {
			logger.info(" Topic details :: Id :: "+audit.getId() +"\t :: Topic Id :: "+audit.getTopicId()+" \t :: Topic Date :: "+audit.getDate_updated_ts()
			+"\t Topic Date Updated :: "+audit.getDate_updated_ts().toString() );

		}
		/*SendEmailImpl email =(SendEmailImpl)context.getBean("sendEmailImpl");
		email.sendEmailFromSpring();*/
		xmlContext.close();


	}
}
