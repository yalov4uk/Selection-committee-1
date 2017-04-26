<%@include file="../includes/init.jsp" %>

<title><fmt:message key="REG_USERS"/>
</title>
<link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><fmt:message key="REG_USERS"/>
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
        <th><fmt:message key="FACULTIES"/>
        </th>
        <th><fmt:message key="CREATE_STATEMENT"/>
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
                   class="button"><fmt:message key="CREATE_STATEMENT"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="../includes/footer.jsp"/>
