<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.logins.DBclass" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String email=request.getParameter("demail"); 

DBclass.delete(email);
%>
<%response.getWriter().print("deleted you idiot"); %>

</body>
</html>