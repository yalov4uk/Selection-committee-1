<%@include file="../includes/init.jsp" %>

<title><fmt:message key="FACULTIES"/>
</title>
<link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><fmt:message key="FACULTIES"/>
    </strong></caption>
    <thead>
    <tr>
        <th><fmt:message key="NAME"/>
        </th>
        <th><fmt:message key="CAPACITY"/>
        </th>
        <th><fmt:message key="SUBJECTS"/>
        </th>
        <c:if test="${user.roleId == 2}">
            <th><fmt:message key="REG_USERS"/>
            </th>
        </c:if>
        <c:if test="${user.roleId == 1}">
            <th><fmt:message key="REG_TO_FAC"/>
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
                            class="button"><fmt:message key="REG_TO_FAC"/>
                    </a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="../includes/footer.jsp"/>
