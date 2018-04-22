/**
 * 
 */
package com.mastertutorial.mvc.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastertutorial.mvc.dao.AnnotationBean;

/**
 * @author Yashwanth
 *
 */
@Component
public class AnnotationBeanImpl implements AnnotationBean{

	
	Date dt1;
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return dt1;
	}

	/**
	 * @param date the date to set
	 */
	@Autowired
	public void setDate(Date date) {
		this.dt1 = date;
	}

	@Override
	public String printHelloWithAnnotations() {
		// TODO Auto-generated method stub
		return dt1.toString();
	}
	

}
