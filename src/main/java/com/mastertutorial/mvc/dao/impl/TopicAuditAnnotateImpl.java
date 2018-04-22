/**
 * 
 */
package com.mastertutorial.mvc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastertutorial.mvc.dao.ITopicAuditAnnotate;
import com.mastertutorial.mvc.dao.TopicAudit;

/**
 * @author Yashwanth
 *
 */
@Component("topicAuditAnnotate")
public class TopicAuditAnnotateImpl implements ITopicAuditAnnotate{

	@Autowired
	private SessionFactory hbmSessionFactory;
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return hbmSessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hbmSessionFactory = sessionFactory;
	}

	@Override
	public List<com.mastertutorial.mvc.model.TopicAuditAnnotate> getData() {
		Session session = hbmSessionFactory.openSession();
		Query query = session.createQuery("from TopicAuditAnnotate");
		
		return query.list();
	}

	
}
