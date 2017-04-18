<%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/18/2017
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach var="role" items="${roles}">
        <tr>
            <td>
                <c:out value="name"/>
                <c:out value="${role.name}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
