<%@include file="../includes/init.jsp" %>

<title><fmt:message key="STATEMENTS"/>
</title>
<link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><fmt:message key="STATEMENTS"/>
    </strong></caption>
    <thead>
    <tr>
        <th><fmt:message key="ID"/>
        </th>
        <th><fmt:message key="USERS"/> <fmt:message key="ID"/>
        </th>
        <th><fmt:message key="FACULTIES"/> <fmt:message key="ID"/>
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
