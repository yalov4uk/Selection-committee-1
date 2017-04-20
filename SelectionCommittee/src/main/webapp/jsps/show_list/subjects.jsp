<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/18/2017
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String SUBJECTS = resourceBundle.getString("SUBJECTS");
%>

<html>
<head>
    <title><%=SUBJECTS%></title>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<table>
    <h2><%=SUBJECTS%></h2>
    <c:forEach var="subject" items="${subjects}">
        <tr>
            <td>
                <c:out value="${subject.value}"/>
                <c:out value="${subject.userId}"/>
                <c:out value="${subject.subjectNameId}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
