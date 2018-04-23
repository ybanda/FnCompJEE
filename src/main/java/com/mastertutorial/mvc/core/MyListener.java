/**
 * 
 */
package com.mastertutorial.mvc.core;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.mysql.jdbc.log.LogFactory;

/**
 * @author Yashwanth
 *
 */
@SuppressWarnings("rawtypes")
public class MyListener implements ApplicationListener{

	private static final Logger logger = LoggerFactory.getLogger(MyListener.class);
	
	long startTime , endTime;
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		logger.info("MyListener :: on Application Event Start");
		if(event.toString().indexOf("ContextRefreshedEvent")!=-1) {
			startTime=System.currentTimeMillis();
			logger.info("MyListener:: The Container is started at :: "+new Date());
		}
		else if(event.toString().indexOf("ContextClosedEvent")!=-1) {
			endTime=System.currentTimeMillis();
			logger.info("MyListener :: The Container is ended at :: "+(endTime-startTime));
		}
	}
}
