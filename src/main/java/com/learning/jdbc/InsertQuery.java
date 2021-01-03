package com.learning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {
	
	
	String url ="jdbc:h2:tcp://localhost/~/test";
	String user="sa";
	String pass="";
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	int rowInserted;

	
	public InsertQuery() {
		
		
		try {
			
			
			Class.forName("org.h2.Driver");
			
			conn=DriverManager.getConnection(url, user, pass);
			
			String query="INSERT INTO USERDETAILS(NAME,EMAIL,ADDRE) "
							+" VALUES ('DEMO1','DEMO1','DEMO1')";
			
			

			 stmt=conn.createStatement();

			 
			 rowInserted=stmt.executeUpdate(query);
			 
			 System.out.println("insertion successfullly");
			
			
		} 
		
		catch (ClassNotFoundException e) 
		{
		
			System.out.println("CLASS NOT FOUND EXCEPTION "+e.getMessage());
		
		
		} catch (SQLException e) {
			
			
			System.out.println("SQL EXCEPTION"+e.getMessage());
		}
		
	}

	public static void main(String[] args) {

		
		InsertQuery obj1=new InsertQuery();
	
	}

}
