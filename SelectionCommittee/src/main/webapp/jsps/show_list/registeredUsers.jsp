<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/19/2017
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registered Users</title>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<c:forEach var="registerUser" items="${registeredUsers}">
    <c:out value="${registerUser.user}"/>
    <c:out value="${registerUser.faculty.name}"/>
    <a href="/controller?command=registerStatement&id=${registerUser.id}">
        <c:out value="register statement"/>
    </a>
    <br>
</c:forEach>
</body>
</html>
