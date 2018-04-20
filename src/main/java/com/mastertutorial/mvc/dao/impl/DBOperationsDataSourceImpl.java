/**
 * 
 */
package com.mastertutorial.mvc.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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

	/**
	 * 
	 */
	public String fetchCourseDescrption(String courseId) {
		String courseDescription="";
		String sql="select description from topic where id=?";
		Map<Integer,String> queryIndexes = new HashMap<Integer,String>();
		queryIndexes.put(1, courseId);
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = createPreparedStatment(conn, queryIndexes,sql);
				ResultSet rs = ps.executeQuery();){
			if(rs.next())
				courseDescription=rs.getString(1);

		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return courseDescription;
	}

	/**
	 * 
	 */
	public String fetchCourseName(String courseId) {
		String courseName = "";
		Map<Integer,String> queryIndexes = new HashMap<Integer,String>();
		queryIndexes.put(1, courseId);
		String sql = "select name from topic where id=?";
		try(Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = createPreparedStatment(connection, queryIndexes,sql);
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

	/**
	 * 
	 * @param connection
	 * @param identifier
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	private PreparedStatement createPreparedStatment(Connection connection , Map<Integer,String> identifier,String sql) throws Exception {

		System.out.println(" Name ::"+identifier.toString());
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		if(identifier!=null && identifier.size()!=0) {
			identifier.forEach((key,value) ->{

				try {
					preparedStatement.setString(key, value);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});
		}


		return preparedStatement;
	}

	@Override
	public int fetchTotalCourses() {
		String sql ="select count(*) from topic";
		try(Connection connection = dataSource.getConnection();
				java.sql.Statement statement = connection.createStatement();
				ResultSet resultSet  = statement.executeQuery(sql)) {

			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}



	/**
	 * 
	 */
	public void addCourse(String id, String name, String description) {
		String sql = "insert into topic values(?,?,?)";
		Map<Integer,String> identifier = new HashMap<Integer,String>();
		identifier.put(1,id);
		identifier.put(2,description);
		identifier.put(3, name);
		int count =0;
		try(Connection connection = dataSource.getConnection();
				PreparedStatement statement = createPreparedStatment(connection, identifier, sql)){
			count  = statement.executeUpdate();
			System.out.println(" "+count +" Record Inserted with id ="+id +", Name ="+name+", Description = "+description);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	/*
	 * 	
	 */
	public int updateCourseReturnCount(String id, String name, String description) {
		String sql="update topic SET name=? ,description=? where id =?";
		Map<Integer,String> identifier = new HashMap<Integer,String>();
		identifier.put(1, name);
		identifier.put(2,description);
		identifier.put(3,id);
		try(Connection connection = dataSource.getConnection();
				PreparedStatement statement = createPreparedStatment(connection, identifier, sql)){

			System.out.println("  Record Updated with id ="+id +", Name ="+name+", Description = "+description);

			return statement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteCourse(String courseId) {
		String sql ="delete from topic where id='"+courseId+"'";
		try(Connection connection = dataSource.getConnection();
				java.sql.Statement statement = connection.createStatement();){
			return statement.executeUpdate(sql) ;
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	

	/*
	  DELIMITER
	  drop procedure if exists proc_total_tables$$
	  create procedure proc_total_tables(IN varchar dbschema , out int count)
	  BEGIN $$
	  select count(*) into count from information_schema.tables where table_schema=dbschema;
	  END $$
	  DELIMITER ;
	  
	  call proc_total_tables('test',@ct)
		select @ct 
	 */
	

	/*
	 set serveroutput on;
	CREATE OR REPLACE PROCEDURE proc_total_tables(invoicenr IN NUMBER, amnt OUT NUMBER)
	AS BEGIN
	SELECT AMOUNT INTO amnt FROM INVOICE WHERE INVOICE_NR = invoicenr;
	END;
	
	DECLARE
	amount NUMBER;
	BEGIN
	PROC1(1000001, amount);
	dbms_output.put_line(amount);
	END;
	 */
	
	@Override
	public int getTablecountFromStoreProc(String schemaName) {
		String sql="call proc_total_tables(?,?)";
		try(Connection connection = dataSource.getConnection();
				CallableStatement callStmt = connection.prepareCall(sql);){
			callStmt.setString(1,schemaName);
			callStmt.registerOutParameter(2, java.sql.Types.INTEGER);
			callStmt.executeUpdate();
			return callStmt.getInt(2);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
}
