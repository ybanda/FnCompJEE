/**
 * 
 */
package com.mastertutorial.mvc.core;

import java.util.Date;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Yashwanth
 *
 */
@SuppressWarnings("rawtypes")
public class MyListener implements ApplicationListener{

	long startTime , endTime;
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("MyListener :: on Application Event Start");
		if(event.toString().indexOf("ContextRefreshedEvent")!=-1) {
			startTime=System.currentTimeMillis();
			System.out.println("MyListener:: The Container is started at :: "+new Date());
		}
		else if(event.toString().indexOf("ContextClosedEvent")!=-1) {
			endTime=System.currentTimeMillis();
			System.out.println("MyListener :: The Container is ended at :: "+(endTime-startTime));
		}
	}
}
