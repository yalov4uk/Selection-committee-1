<%@include file="../includes/init.jsp" %>

<title><fmt:message key="USERS"/>
</title>
<link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><fmt:message key="USERS"/>
    </strong></caption>
    <thead>
    <tr>
        <th><fmt:message key="NAME"/>
        </th>
        <th><fmt:message key="LOGIN"/>
        </th>
        <th><fmt:message key="PASSWORD"/>
        </th>
        <th><fmt:message key="ROLE"/>
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
