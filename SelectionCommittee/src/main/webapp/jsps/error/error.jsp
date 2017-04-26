<%@include file="../includes/init.jsp" %>

<title><fmt:message key="ERROR"/>
</title>

<jsp:include page="../includes/header.jsp"/>

<div style="text-align: center; margin-top: 9%">
    <fmt:message key="SOME_WRONG" var="SOME_WRONG"/>
    <c:out value="${SOME_WRONG}"/>.
    <br>
    <c:out value="${errorMessage}"/>
</div>

<jsp:include page="../includes/footer.jsp"/>
