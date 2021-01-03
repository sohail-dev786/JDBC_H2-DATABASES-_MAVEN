package com.learning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery {

	
	
	String url ="jdbc:h2:tcp://localhost/~/test";
	String user="sa";
	String pass="";
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	
	public SelectQuery()
	{
		
		try {
			
			
			
			Class.forName("org.h2.Driver");
		
			conn=DriverManager.getConnection(url, user, pass);
			
			System.out.println("CONNECTION SUCCESSFULLY !");
			

			
			
			String query="SELECT * FROM USERDETAILS ";
			
			stmt=conn.createStatement();
			
			
			ResultSet result=stmt.executeQuery(query);
			
			
			while(result.next())
			{
				
				String name=result.getString("name");
				String email=result.getString("email");
				String addre=result.getString("addre");
				
				
				
				System.out.println();
				
				System.out.println("NAME :"+name);
				System.out.println("EMAIL:"+email);
				System.out.println("ADDRE :"+addre);
				
				System.out.println();
				
			}
			result.close();
			
			
		
		} 
		catch (ClassNotFoundException e) {
		
		System.out.println("CLASS NOT FOUND EXCEPTION"+e.getMessage());
		
		
		} catch (SQLException e) {
			
		System.out.println("SQL EXCEPTION"+e.getMessage());
		}
	
	}
	
	
	
	
	public static void main(String[] args) {


		
		SelectQuery obj=new SelectQuery();
		
		
		
	}

}
