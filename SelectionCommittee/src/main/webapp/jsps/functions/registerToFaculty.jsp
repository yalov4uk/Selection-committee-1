<%@include file="../includes/init.jsp" %>

<title><fmt:message key="REGISTER_TO_FACULTY"/>
</title>
<script type="text/javascript" src="/js/validator.js"></script>
<style>
    .tab {
        padding-top: 5%;
        text-align: center;
    }
</style>

<jsp:include page="../includes/header.jsp"/>

<div class="tab">
    <h2><fmt:message key="REGISTER_TO_FACULTY"/>
    </h2>
    <form id="reg_form" action="/controller" method="post" onsubmit="return registerToFaculty();">
        <fmt:message key="VALUE_REQ" var="VALUE_REQ"/>
        <input type="hidden" id="VALUE_REQ" value="${VALUE_REQ}"/>
        <input type="hidden" name="command" value="registerToFacultyPost"/>
        <table>
            <c:forEach var="subjectName" items="${subjectNames}">
                <tr>
                    <td>
                        <c:out value="${subjectName.name}"/>
                        <input class="value" type="text" name="value" placeholder="0<x<100"/>
                        <input type="hidden" name="subjectNameId" value="${subjectName.id}"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <fmt:message key="SIGN_UP" var="SIGN_UP"/>
        <input type="submit" id="submit" value="${SIGN_UP}">
    </form>
</div>

<jsp:include page="../includes/footer.jsp"/>
