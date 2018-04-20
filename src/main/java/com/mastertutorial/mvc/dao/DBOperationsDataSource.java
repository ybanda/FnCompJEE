/**
 * 
 */
package com.mastertutorial.mvc.dao;

/**
 * @author Yashwanth
 *
 */
public interface DBOperationsDataSource {

	public int fetchCourseDescrption(String courseId);
	public String fetchCourseName(String courseId );
}
