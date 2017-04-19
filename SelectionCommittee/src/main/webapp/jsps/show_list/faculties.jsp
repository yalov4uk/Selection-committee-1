<%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/18/2017
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Faculties</title>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<table>
    <c:forEach var="faculty" items="${faculties}">
        <tr>
            <td><c:out value="name"/>
                <c:if test="${user.roleId == 1}">
                        <c:out value="${faculty.name}"/>
                    <a href="/controller?command=registerToFaculty&name=${faculty.name}">
                        <c:out value="register to faculty"/>
                    </a>
                </c:if>
                <c:if test="${user.roleId == 2}">
                    <c:out value="${faculty.name}"/>
                </c:if>
            </td>
        </tr>
        <tr>
            <td><c:out value="size"/>
                <c:out value="${faculty.maxSize}"/></td>
        </tr>
        <tr>
            <td><c:forEach var="requiredSubject" items="${faculty.requiredSubjects}">
                <c:out value="${requiredSubject.name}"/>
            </c:forEach></td>
        </tr>
        <tr>
            <td><c:forEach var="registeredUser" items="${faculty.registeredUsers}">
                <c:if test="${user.roleId == 2}">
                    <c:out value="${registeredUser}"/>
                </c:if>
                <br>
            </c:forEach></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
