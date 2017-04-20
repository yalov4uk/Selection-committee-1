<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/18/2017
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String FACULTIES = resourceBundle.getString("FACULTIES");
    String REG_TO_FAC = resourceBundle.getString("REG_TO_FAC");
%>

<html>
<head>
    <title><%=FACULTIES%>
    </title>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<h2><%=FACULTIES%>
</h2>
<table>
    <c:forEach var="faculty" items="${faculties}">
        <tr>
            <td>
                <c:if test="${user.roleId == 1}">
                    <c:out value="${faculty.name}"/>
                    <a href="/controller?command=registerToFaculty&name=${faculty.name}">
                        <c:out value="<%=REG_TO_FAC%>"/>
                    </a>
                </c:if>
                <c:if test="${user.roleId == 2}">
                    <c:out value="${faculty.name}"/>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>
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
