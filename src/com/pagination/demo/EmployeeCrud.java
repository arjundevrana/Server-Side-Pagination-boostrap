package com.pagination.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeCrud {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/deputation";
		String username = "root";
		String password = "root";
		 
		try {
		 
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		 
		    if (conn != null) {
		        System.out.println("Connected");
		        String sql = "INSERT INTO person (id, name, place, city,state,phone) VALUES (?, ?, ?, ?,?,?)";
		        
		        for(int i=1;i<10000;i++) {
		        	PreparedStatement statement = conn.prepareStatement(sql);
			        statement.setInt(1,100+i);
			        statement.setString(2, "name"+i);
			        statement.setString(3, "place"+i);
			        statement.setString(4, "city"+i);
			        statement.setString(5, "state"+i);
			        statement.setString(6, "phone"+i);
			         
			        int rowsInserted = statement.executeUpdate();
			        if (rowsInserted > 0) {
			            System.out.println("A new user was inserted successfully!");
			        }	
		        }
		        
		        
		    }
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}

	}

}
