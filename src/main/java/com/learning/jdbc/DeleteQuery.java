package com.learning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery {

	String user = "sa";
	String pass = "";
	String url = "jdbc:h2:tcp://localhost/~/test";

	Statement stmt;
	Connection conn;
	PreparedStatement pstmt;
	String query;
	ResultSet result;

	public DeleteQuery() {

		try {
			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection(url, user, pass);

			System.out.println("CONNECTION SUCCESSFULLY");

			System.out.println("==========================");

			System.out.println("BEFORE DELETING THE RECORD");

			query ="SELECT * FROM USERDETAILS";

			stmt = conn.createStatement();

			result = stmt.executeQuery(query);

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String email = result.getString("email");
				String addre = result.getString("addre");

				System.out.println();

				System.out.println("NAME :" + name);
				System.out.println("EMAIL:" + email);
				System.out.println("ADDRE :" + addre);
				System.out.println("ID " + id);

				System.out.println();

			}
			result.close();

			query = "DELETE FROM USERDETAILS WHERE ID =7";

			stmt = conn.createStatement();
			int rowDeleted = stmt.executeUpdate(query);

			System.out.println("==========================");
			System.out.println("RECORD DELETED SUCCESSFULLY");

			System.out.println("==========================");

			System.out.println("AFTER DELETING RECORD");

			query = "	SELECT * FROM USERDETAILS";

			stmt = conn.createStatement();

			ResultSet result = stmt.executeQuery(query);

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String email = result.getString("email");
				String addre = result.getString("addre");

				System.out.println();

				System.out.println("NAME :" + name);
				System.out.println("EMAIL:" + email);
				System.out.println("ADDRE :" + addre);
				System.out.println("ID :" + id);

				System.out.println();

			}
			result.close();

		} catch (ClassNotFoundException e) {

			System.out.println("Class Not Found Exception" + e.getMessage());

		} catch (SQLException e) {

			System.out.println("SQL EXCEPTION" + e.getMessage());
		}

	}

	public static void main(String args[]) {

		DeleteQuery obj = new DeleteQuery();

	}

}
