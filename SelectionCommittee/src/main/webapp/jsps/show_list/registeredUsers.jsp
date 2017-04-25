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
    String FACULTIES = resourceBundle.getString("FACULTIES");
    String LOGIN = resourceBundle.getString("LOGIN");
    String PASSWORD = resourceBundle.getString("PASSWORD");
    String NAME = resourceBundle.getString("NAME");
    String ROLE = resourceBundle.getString("ROLE");
%>

<title><%=REG_USERS%>
</title>
<link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><%=REG_USERS%>
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
        <th><%=FACULTIES%>
        </th>
        <th><%=CREATE_STATEMENT%>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="registerUser" items="${registeredUsers}">
        <tr>
            <td>
                <c:out value="${registerUser.user.name}"/>
            </td>
            <td>
                <c:out value="${registerUser.user.login}"/>
            </td>
            <td>
                <c:out value="${registerUser.user.password}"/>
            </td>
            <td>
                <c:out value="${registerUser.user.roleId}"/>
            </td>
            <td>
                <c:out value="${registerUser.faculty.name}"/>
            </td>
            <td>
                <a href="/controller?command=registerStatement&id=${registerUser.id}"
                   class="button"><%=CREATE_STATEMENT%>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="../includes/footer.jsp"/>
