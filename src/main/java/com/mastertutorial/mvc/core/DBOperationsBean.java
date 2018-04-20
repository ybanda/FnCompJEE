/**
 * 
 */
package com.mastertutorial.mvc.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author Yashwanth
 *
 */
public class DBOperationsBean implements DBOperations{

	DataSource dataSource;
	
	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int fetchCourseDescrption(String courseId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String fetchCourseName(String courseId) {
		String courseName = "";
		try(Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = createPreparedStatment(connection, courseId);
				ResultSet resultSet  = preparedStatement.executeQuery()){
			
			while(resultSet.next()) {
				courseName = resultSet.getString(0);
			}
			
			
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return courseName;
	}
	
	private PreparedStatement createPreparedStatment(Connection connection , Object identifier) throws SQLException {
		String sql = "select name from topic where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, identifier.toString());
		
		return preparedStatement;
	}

}
