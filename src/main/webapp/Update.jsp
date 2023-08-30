<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="com.logins.DBclass" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update here</title>
</head>
<body>

<%String email=request.getParameter("email");%>
<%String password=request.getParameter("newpass");%>
<%DBclass.update(email, password);%>
<%response.sendRedirect("signup.html"); %>



</body>
</html>