package com.learning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateQuery {
	
	
	

	String url ="jdbc:h2:tcp://localhost/~/test";
	String user="sa";
	String pass="";
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	int rowInserted;
	ResultSet result;
	
	public UpdateQuery() {
		
		try {
			
			Class.forName("org.h2.Driver");
			
			conn=DriverManager.getConnection(url, user, pass);
			
			String query;
			
				
			//BEFORE UPDATE
			
			System.out.println("BEFORE UPDATE VALUE");
			
			query="SELECT * FROM USERDETAILS";
			
			stmt=conn.createStatement();
			
			result=stmt.executeQuery(query);
			
			
			while(result.next())
			{
				
				int id=result.getInt("id");
				String name=result.getString("name");
				String email=result.getString("email");
				String addre=result.getString("addre");
				
				
				
				System.out.println();
				
				System.out.println("NAME :"+name);
				System.out.println("EMAIL:"+email);
				System.out.println("ADDRE :"+addre);
				System.out.println("ID" +id);
				
				System.out.println();
				
			}
			result.close();
			
			
			
			
			
			 query="UPDATE USERDETAILS SET NAME='DHAMAAL1',EMAIL='DHAMAAL1@GMAIL.COM' WHERE ID=8 ";
			
			
			stmt=conn.createStatement();
			int rowAffected=stmt.executeUpdate(query);
			System.out.println("ROW UPDADTED SUCESSFULLY");
			
			
			
			
			System.out.println("===========================");
			
			
			//AFTER UPDATE 
			System.out.println("AFTER UPDATE VALUE");
			
			
			
			query="SELECT * FROM USERDETAILS";
			
			stmt=conn.createStatement();
			
			result=stmt.executeQuery(query);
			
			
			while(result.next())
			{
				

				int id=result.getInt("id");
				String name=result.getString("name");
				String email=result.getString("email");
				String addre=result.getString("addre");
				
				
				
				System.out.println();
				
				System.out.println("NAME :"+name);
				System.out.println("EMAIL:"+email);
				System.out.println("ADDRE :"+addre);
				System.out.println("ID" +id);
				
				System.out.println();

				
			}
			result.close();
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("CLASS NOT FOUND EXCEPTION"+e.getMessage());
			
		} catch (SQLException e) {
			
			System.out.println("SQL EXCEPTION"+e.getMessage());
			
		}
	
		
	
	}
	
	
	
	public static void main(String args[])
	{
		
		UpdateQuery obj=new UpdateQuery();
		
		
	}
	
	

}
