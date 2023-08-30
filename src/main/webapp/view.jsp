<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.logins.DBclass" %>
    <%@ page import="java.sql.ResultSet" %>
    <%! int i; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>data</title>
</head>
<body>
<h1>users data</h1>
<%
ResultSet re=DBclass.view(); 
ArrayList<String> em=new ArrayList<String>();
ArrayList<String> ps=new ArrayList<String>();
while(re.next()){
	em.add(re.getString(1));
	ps.add(re.getString(2));
}
int size=em.size();


%>



<%for(i=0;i<size;i++){ %>
 
 <p> Email=<%= em.get(i) %> </p>
 
 <p>password =<%= ps.get(i) %></p>
 <p>____________________________________</p>
<%} %>



</body>
</html>