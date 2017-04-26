<%@include file="../includes/init.jsp" %>

    <title><fmt:message key="ROLES"/>
    </title>
    <link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><fmt:message key="ROLES"/>
    </strong></caption>
    <thead>
    <tr>
        <th><fmt:message key="ID"/>
        </th>
        <th><fmt:message key="NAME"/>
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
