<%@page import="java.util.List"%>
<%@page import="com.spittr.model.Spitter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Record</title>
</head>
<body>
 <% List<Spitter> spitters = (List<Spitter>)request.getAttribute("spitters"); %>
 <table border="1" style="width: 50%" height="50%">
  <thead>
   <tr>
    <th>ID</th>
    <th>Username</th>
    <th>Password</th>
    <th>FullName</th>
   </tr>
  </thead>
  <tbody>
   <!--   for (Todo todo: todos) {  -->
   <% for(Spitter spitter : spitters){ %>
   <tr>
    <td><%=spitter.getId()%></td>
    <td><%=spitter.getUsername()%></td>
    <td><%=spitter.getPassword()%></td>
    <td><%=spitter.getFullName()%></td>
   </tr>
   <%} %>
  </tbody>

 </table>
</body>
</html>