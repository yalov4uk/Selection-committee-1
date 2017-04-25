<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/18/2017
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String STATEMENTS = resourceBundle.getString("STATEMENTS");
    String FACULTIES = resourceBundle.getString("FACULTIES");
    String USERS = resourceBundle.getString("USERS");
    String ID = resourceBundle.getString("ID");
%>

<title><%=STATEMENTS%>
</title>
<link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><%=STATEMENTS%>
    </strong></caption>
    <thead>
    <tr>
        <th><%=ID%>
        </th>
        <th><%=USERS%> <%=ID%>
        </th>
        <th><%=FACULTIES%> <%=ID%>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="statement" items="${statements}">
        <tr>
            <td>
                <c:out value="${statement.id}"/>
            </td>
            <td>
                <c:out value="${statement.userId}"/>
            </td>
            <td>
                <c:out value="${statement.facultyId}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="../includes/footer.jsp"/>
