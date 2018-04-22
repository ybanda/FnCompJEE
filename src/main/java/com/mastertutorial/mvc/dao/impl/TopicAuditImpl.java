/**
 * 
 */
package com.mastertutorial.mvc.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.mastertutorial.mvc.dao.TopicAudit;

/**
 * @author Yashwanth
 *
 */
public class TopicAuditImpl implements TopicAudit{

	private HibernateTemplate hibernateTemplate;
	
	

	/**
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * @param hibernateTemplate the hibernateTemplate to set
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<com.mastertutorial.mvc.model.TopicAudit> getData() {
		return (List<com.mastertutorial.mvc.model.TopicAudit>) hibernateTemplate.find("from TopicAudit");
		
	}

}
