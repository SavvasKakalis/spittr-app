<%@page import="java.util.List"%>
<%@page import="com.spittr.model.Spittle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Record</title>
</head>
<body>
 <% List<Spittle> spittles = (List<Spittle>)request.getAttribute("spittles"); %>
 <table border="1" style="width: 50%" height="50%">
  <thead>
   <tr>
    <th>ID</th>
    <th>Message</th>
    <th>Time Submitted</th>
    <th>Spitter</th>
   </tr>
  </thead>
  <tbody>
   <!--   for (Todo todo: todos) {  -->
   <% for(Spittle spittle : spittles){ %>
   <tr>
    <td><%=spittle.getId()%></td>
    <td><%=spittle.getMessage()%></td>
    <td><%=spittle.getTimeSubmitted()%></td>
    <td><%=spittle.getSpitter().getId()%></td>
   </tr>
   <%} %>
  </tbody>

 </table>
</body>
</html>