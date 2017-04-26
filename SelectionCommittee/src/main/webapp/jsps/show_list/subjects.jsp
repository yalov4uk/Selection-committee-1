<%@include file="../includes/init.jsp" %>

<title><fmt:message key="SUBJECTS"/>
</title>
<link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><fmt:message key="SUBJECTS"/>
    </strong></caption>
    <thead>
    <tr>
        <th><fmt:message key="VALUE"/>
        </th>
        <th><fmt:message key="USERS"/> <fmt:message key="ID"/>
        </th>
        <th><fmt:message key="SUBJECT_NAME_ID"/>
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
