<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/18/2017
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String ROLES = resourceBundle.getString("ROLES");
%>

<html>
<head>
    <title><%=ROLES%></title>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<h2><%=ROLES%></h2>
<table>
    <c:forEach var="role" items="${roles}">
        <tr>
            <td>
                <c:out value="${role}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
