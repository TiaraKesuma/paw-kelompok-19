<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Users</title>
</head>
<body>

<%@page import="com.pihda.paw19.dao.EmployeeDAO,com.pihda.paw19.entity.Employee,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Users List</h1>
<%
    List<Employee> employees = request.getParameterValues("employees");
%>
<table border="1" width="90%">
    <tr><th>First Name</th><th>Last Name</th><th>Role</th></tr>
<c:forEach items="${employees}" var="u">
    <tr><td>${u.getFirstName()}</td><td>${u.getLastName()}</td><td>${u.getRole()}</td></tr>
            <%--<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
            <td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td></tr>--%>
</c:forEach>
</table>
<br/><a href="adduserform.jsp">Add New User</a>

</body>
</html>