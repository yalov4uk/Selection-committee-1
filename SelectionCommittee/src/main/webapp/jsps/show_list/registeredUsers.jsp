<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/19/2017
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String REG_USERS = resourceBundle.getString("REG_USERS");
    String CREATE_STATEMENT = resourceBundle.getString("CREATE_STATEMENT");
%>

<html>
<head>
    <title><%=REG_USERS%></title>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<h2><%=REG_USERS%></h2>
<c:forEach var="registerUser" items="${registeredUsers}">
    <c:out value="${registerUser.user}"/>
    <c:out value="${registerUser.faculty.name}"/>
    <a href="/controller?command=registerStatement&id=${registerUser.id}">
        <c:out value="<%=CREATE_STATEMENT%>"/>
    </a>
    <br>
</c:forEach>
</body>
</html>
