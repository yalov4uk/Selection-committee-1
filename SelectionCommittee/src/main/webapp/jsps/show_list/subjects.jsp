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
    String USERS = resourceBundle.getString("USERS");
    String SUBJECT_NAME_ID = resourceBundle.getString("SUBJECT_NAME_ID");
    String ID = resourceBundle.getString("ID");
    String VALUE = resourceBundle.getString("VALUE");
%>

<title><%=SUBJECTS%>
</title>
<link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><%=SUBJECTS%>
    </strong></caption>
    <thead>
    <tr>
        <th><%=VALUE%>
        </th>
        <th><%=USERS%> <%=ID%>
        </th>
        <th><%=SUBJECT_NAME_ID%>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="subject" items="${subjects}">
        <tr>
            <td>
                <c:out value="${subject.value}"/>
            </td>
            <td>
                <c:out value="${subject.userId}"/>
            </td>
            <td>
                <c:out value="${subject.subjectNameId}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="../includes/footer.jsp"/>
