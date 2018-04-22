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
	public void addCourse(String id , String name , String description,boolean isJDBCTemplate);
	public int updateCourseReturnCount(String id , String name , String description,boolean isJDBCTemplate);
	public int deleteCourse(String courseId);
	public int getTablecountFromStoreProc(String schemaName);

}
