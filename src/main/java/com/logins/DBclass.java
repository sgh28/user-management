package com.logins;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBclass {

	public static ResultSet view() {
		
		try {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/logins";
			String user="root";
			String pswd="root";
			String sqlp="select*from users";
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, pswd);
		   Statement cs= con.createStatement();
			
			 ResultSet re= cs.executeQuery(sqlp);
			 
			 return re;
			
			
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		
	}
		return null;
	
	}
	
	public static void add(String email,String password) {

		try {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/logins";
			String user="root";
			String pswd="root";
			String sqlQ="insert into users values(?,?)";
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, pswd);
			PreparedStatement ps= con.prepareStatement(sqlQ);
			ps.setString(1,email);
			ps.setString(2,password);
			ps.executeUpdate();
			
		}catch (Exception e) {
			// TODO:  exception
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static void delete(String email) {

		try {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/logins";
			String user="root";
			String pswd="root";
			String sqlQ="DELETE FROM users WHERE email=?"; 
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, pswd);
			PreparedStatement ps= con.prepareStatement(sqlQ);
			ps.setString(1,email);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			// TODO:  exception
			e.printStackTrace();
		}
	}
		
		
		public static void update(String email,String newpass){
			
			try {
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/logins";
				String user="root";
				String pswd="root";
				String sqlp="UPDATE users SET pass = ? WHERE email = ?; ";
				Class.forName(driver);
				Connection con=DriverManager.getConnection(url, user, pswd);
				PreparedStatement ps= con.prepareStatement(sqlp);
				ps.setString(1,newpass);
				ps.setString(2,email);
		
				ps.executeUpdate();
				
			}catch (Exception e) {
				// TODO:  exception
				e.printStackTrace();
			}
				
				 
				 
				
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
