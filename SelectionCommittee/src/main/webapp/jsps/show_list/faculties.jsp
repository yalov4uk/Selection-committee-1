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
    String SUBJECTS = resourceBundle.getString("SUBJECTS");
    String REG_USERS = resourceBundle.getString("REG_USERS");
    String NAME = resourceBundle.getString("NAME");
    String CAPACITY = resourceBundle.getString("CAPACITY");
%>

    <title><%=FACULTIES%>
    </title>
    <link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><%=FACULTIES%>
    </strong></caption>
    <thead>
    <tr>
        <th><%=NAME%>
        </th>
        <th><%=CAPACITY%>
        </th>
        <th><%=SUBJECTS%>
        </th>
        <c:if test="${user.roleId == 2}">
            <th><%=REG_USERS%>
            </th>
        </c:if>
        <c:if test="${user.roleId == 1}">
            <th><%=REG_TO_FAC%>
            </th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="faculty" items="${faculties}">
        <tr>
            <td>
                <c:out value="${faculty.name}"/>
            </td>
            <td>
                <c:out value="${faculty.maxSize}"/>
            </td>
            <td>
                <c:forEach var="requiredSubject" items="${faculty.requiredSubjects}">
                    <c:out value="${requiredSubject.name}"/>
                </c:forEach></td>
            </td>

            <c:if test="${user.roleId == 2}">
                <td>
                    <c:forEach var="registeredUser" items="${faculty.registeredUsers}">
                        <c:out value="${registeredUser.name}"/>
                    </c:forEach></td>
            </c:if>
            </td>
            <td>
                <c:if test="${user.roleId == 1}">
                    <a
                            href="/controller?command=registerToFaculty&name=${faculty.name}"
                            class="button"><%=REG_TO_FAC%>
                    </a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="../includes/footer.jsp"/>
