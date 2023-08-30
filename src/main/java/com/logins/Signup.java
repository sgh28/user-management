package com.logins;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/next")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String email=request.getParameter("email");
	String password=request.getParameter("pass");
	//response.getWriter().print(email+"    "+password);
	
	
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
		System.out.println("connection succesful");
		response.sendRedirect("home.html");
		
	}catch (Exception e) {
		// TODO:  exception
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
