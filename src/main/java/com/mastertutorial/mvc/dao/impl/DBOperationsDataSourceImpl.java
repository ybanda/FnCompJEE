/**
 * 
 */
package com.mastertutorial.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mastertutorial.mvc.dao.DBOperationsDataSource;

/**
 * @author Yashwanth
 *
 */
public class DBOperationsDataSourceImpl implements DBOperationsDataSource{

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
				courseName = resultSet.getString(1);
			}
			
			
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return courseName;
	}
	
	private PreparedStatement createPreparedStatment(Connection connection , Object identifier) throws SQLException {
		
		System.out.println(" Name ::"+identifier.toString());
		String sql = "select name from topic where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, identifier.toString());
		
		return preparedStatement;
	}

}
