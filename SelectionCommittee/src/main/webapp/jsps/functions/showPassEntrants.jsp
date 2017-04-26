<%@include file="../includes/init.jsp" %>

<title><fmt:message key="SHOW_ENTRANTS"/>
</title>
<link rel="stylesheet" href="/css/show_list/table.css">

<jsp:include page="../includes/header.jsp"/>

<table class="table">
    <caption><strong><fmt:message key="ENTRANTS"/>
    </strong></caption>
    <thead>
    <tr>
        <th>
        </th>
        <th><fmt:message key="FACULTIES"/> <fmt:message key="NAME"/>
        </th>
        <th><fmt:message key="NAME"/>
        </th>
        <th><fmt:message key="POINTS"/>
        </th>
        <th><fmt:message key="STATUS"/>
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
                            <fmt:message key="ACCEPT" var="ACCEPT"/>
                            <c:out value="${ACCEPT}"/>
                        </c:if>
                        <c:if test="${i >= list.get(0).faculty.maxSize}">
                            <fmt:message key="REJECT" var="REJECT"/>
                            <c:out value="${REJECT}"/>
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
