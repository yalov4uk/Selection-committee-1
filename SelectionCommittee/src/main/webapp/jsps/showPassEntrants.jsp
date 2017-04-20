<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/19/2017
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String SHOW_ENTRANTS = resourceBundle.getString("SHOW_ENTRANTS");
    String ENTRANTS = resourceBundle.getString("ENTRANTS");
    String ACCEPT = resourceBundle.getString("ACCEPT");
    String REJECT = resourceBundle.getString("REJECT");
%>

<html>
<head>
    <title><%=SHOW_ENTRANTS%></title>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<h2><%=ENTRANTS%></h2>
<c:forEach var="list" items="${passEntrants.values()}">
    <c:if test="${!list.isEmpty()}">
        <c:out value="${list.get(0).faculty.name}:"/>
        <c:set var="i" value="${0}"/>
        <c:forEach var="elem" items="${list}">
            <c:out value="${elem.user}"/>
            <c:if test="${i < list.get(0).faculty.maxSize}">
                <c:out value="<%=ACCEPT%>"/>
            </c:if>
            <c:if test="${i >= list.get(0).faculty.maxSize}">
                <c:out value="<%=REJECT%>"/>
            </c:if>
            <c:set var="i" value="${i + 1}"/>
            <br>
        </c:forEach>
        <br>
    </c:if>
</c:forEach>
</body>
</html>
