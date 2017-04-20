<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/18/2017
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String REGISTER_TO_FACULTY = resourceBundle.getString("REGISTER_TO_FACULTY");
    String SIGN_UP = resourceBundle.getString("SIGN_UP");
    String VALUE_REQ = resourceBundle.getString("VALUE_REQ");
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><%=REGISTER_TO_FACULTY%></title>
    <script type="text/javascript" src="/js/validator.js"></script>
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<h2><%=REGISTER_TO_FACULTY%></h2>
<form action="/controller" method="post" onsubmit="return registerToFaculty();">
    <input type="hidden" id="VALUE_REQ" value="<%=VALUE_REQ%>" />
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
    <input type="submit" id="submit" value="<%=SIGN_UP%>">
</form>
</body>
</html>
