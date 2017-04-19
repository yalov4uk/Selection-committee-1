<%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/18/2017
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Register to faculty</title>
    <script type="text/javascript" src="/js/validator.js"></script>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<form action="/controller" method="post" onsubmit="return registerToFaculty();">
    <input type="hidden" name="command" value="registerToFacultyPost"/>
    <table>
        <c:forEach var="subjectName" items="${subjectNames}" >
            <tr>
                <td>
                    <c:out value="${subjectName.name}"/>
                    <input id="value" type="text" name="value" placeholder="0<x<100"/>
                    <input type="hidden" name="subjectNameId" value="${subjectName.id}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" id="submit" value="Register to faculty">
</form>
</body>
</html>
