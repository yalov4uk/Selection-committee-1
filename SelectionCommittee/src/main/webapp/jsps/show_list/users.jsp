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
    String NAME = resourceBundle.getString("NAME");
    String LOGIN = resourceBundle.getString("LOGIN");
    String PASSWORD = resourceBundle.getString("PASSWORD");
    String ROLE = resourceBundle.getString("ROLE");
%>

<title><%=USERS%>
</title>
<link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><%=USERS%>
    </strong></caption>
    <thead>
    <tr>
        <th><%=NAME%>
        </th>
        <th><%=LOGIN%>
        </th>
        <th><%=PASSWORD%>
        </th>
        <th><%=ROLE%>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <c:out value="${user.name}"/>
            </td>
            <td>
                <c:out value="${user.login}"/>
            </td>
            <td>
                <c:out value="${user.password}"/>
            </td>
            <td>
                <c:out value="${user.roleId}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</table>

<jsp:include page="../includes/footer.jsp"/>
