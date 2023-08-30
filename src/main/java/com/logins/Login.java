package com.logins;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/logins";
			String user="root";
			String pswd="root";
			String sqlp="select*from users";
			String email=request.getParameter("e");
			String pass=request.getParameter("p");
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, pswd);
		   Statement cs= con.createStatement();
			
			 ResultSet re= cs.executeQuery(sqlp);
			 
			 while(re.next()) {
				 if(email.equals(re.getString(1))&& pass.equals(re.getString(2))) {
					 response.sendRedirect("home.html");
				 }
				 
			 }
			 response.sendRedirect("error.html");
			 
			System.out.println("connection succesful");
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
