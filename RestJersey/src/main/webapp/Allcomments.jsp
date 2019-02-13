<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>   
<%@page import="Dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Comments:</h1>

<table border="1">
<tr>
<td>UserName</td>
<td>Comment</td>

</tr>

<%
try{
	DbConnection dbConnect= new DbConnection();
	PreparedStatement ps = dbConnect.getConnection().prepareStatement("select * from usercomments;");
	
	ResultSet resultSet = ps.executeQuery();
	while(resultSet.next()) {
%>
<tr>
<td><%=resultSet.getString("username") %></td>
<td><%=resultSet.getString("comments") %></td>

</tr>		
<%
}
}
catch (Exception e) {
e.printStackTrace();
}
%>	
	
</table>
</body>
</html>



