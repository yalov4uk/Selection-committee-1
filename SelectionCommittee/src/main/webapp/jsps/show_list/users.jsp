<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/18/2017
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String USERS = resourceBundle.getString("USERS");
%>

<html>
<head>
    <title><%=USERS%></title>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<h2><%=USERS%></h2>
<table>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <c:out value="${user}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
