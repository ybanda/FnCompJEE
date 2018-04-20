/**
 * 
 */
package com.mastertutorial.mvc.dao;

/**
 * @author Yashwanth
 *
 */
public interface DBOperationsDataSource {

	public String fetchCourseDescrption(String courseId);
	public String fetchCourseName(String courseId );
	public int fetchTotalCourses();
	public void addCourse(String id , String name , String description);
	public int updateCourseReturnCount(String id , String name , String description);
	public int deleteCourse(String courseId);
	public int getTablecountFromStoreProc(String schemaName);
}
