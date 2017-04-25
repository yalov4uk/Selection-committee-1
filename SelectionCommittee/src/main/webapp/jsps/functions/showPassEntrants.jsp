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
    String FACULTIES = resourceBundle.getString("FACULTIES");
    String NAME = resourceBundle.getString("NAME");
    String POINTS = resourceBundle.getString("POINTS");
    String STATUS = resourceBundle.getString("STATUS");
%>


<title><%=SHOW_ENTRANTS%>
</title>
<link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><%=ENTRANTS%>
    </strong></caption>
    <thead>
    <tr>
        <th>
        </th>
        <th><%=FACULTIES%> <%=NAME%>
        </th>
        <th><%=NAME%>
        </th>
        <th><%=POINTS%>
        </th>
        <th><%=STATUS%>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${passEntrants.values()}">
        <c:if test="${!list.isEmpty()}">
            <c:set var="i" value="${0}"/>
            <c:forEach var="elem" items="${list}">
                <tr>
                    <td>
                        <c:out value="${i + 1}"/>
                    </td>
                    <td>
                        <c:out value="${list.get(0).faculty.name}"/>
                    </td>
                    <td>
                        <c:out value="${elem.user.name}"/>
                    </td>
                    <td>
                        <c:out value="${elem.user.getAverageScore(list.get(0).faculty)}"/>
                    </td>
                    <td>
                        <c:if test="${i < list.get(0).faculty.maxSize}">
                            <c:out value="<%=ACCEPT%>"/>
                        </c:if>
                        <c:if test="${i >= list.get(0).faculty.maxSize}">
                            <c:out value="<%=REJECT%>"/>
                        </c:if>
                    </td>
                </tr>
                <c:set var="i" value="${i + 1}"/>
            </c:forEach>
        </c:if>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="../includes/footer.jsp"/>
