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
    String ID = resourceBundle.getString("ID");
    String NAME = resourceBundle.getString("NAME");
%>

    <title><%=ROLES%>
    </title>
    <link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><%=ROLES%>
    </strong></caption>
    <thead>
    <tr>
        <th><%=ID%>
        </th>
        <th><%=NAME%>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="role" items="${roles}">
        <tr>
            <td>
                <c:out value="${role.id}"/>
            </td>
            <td>
                <c:out value="${role.name}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="../includes/footer.jsp"/>
