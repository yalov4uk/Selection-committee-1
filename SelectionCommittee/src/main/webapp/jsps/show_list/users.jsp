<%@ page import="by.training.nc.dev3.localisation.Bundle" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Valera Yalov4uk
  Date: 4/18/2017
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ResourceBundle resourceBundle = Bundle.getInstance();
    String USERS = resourceBundle.getString("USERS");
    String FACULTIES = resourceBundle.getString("FACULTIES");
    String REG_TO_FAC = resourceBundle.getString("REG_TO_FAC");
    String SELECTION_COMMITTEE = resourceBundle.getString("SELECTION_COMMITTEE");
    String HELLO = resourceBundle.getString("HELLO");
    String LOGOUT = resourceBundle.getString("LOGOUT");
    String CHANGE_LANGUAGE = resourceBundle.getString("CHANGE_LANGUAGE");
    String HOME = resourceBundle.getString("HOME");
    String ABOUT = resourceBundle.getString("ABOUT");
    String SOME_FUNCTIONS = resourceBundle.getString("SOME_FUNCTIONS");
    String ROLES = resourceBundle.getString("ROLES");
    String STATEMENTS = resourceBundle.getString("STATEMENTS");
    String SUBJECTS = resourceBundle.getString("SUBJECTS");
    String REG_USERS = resourceBundle.getString("REG_USERS");
    String CALCULATE_AND_SHOW_ENTRANTS = resourceBundle.getString("CALCULATE_AND_SHOW_ENTRANTS");
    String SOMETHING_ELSE = resourceBundle.getString("SOMETHING_ELSE");
    String CONTACT = resourceBundle.getString("CONTACT");
    String LOG_IN = resourceBundle.getString("LOG_IN");
    String SIGN_UP = resourceBundle.getString("SIGN_UP");
    String NAME = resourceBundle.getString("NAME");
    String LOGIN = resourceBundle.getString("LOGIN");
    String PASSWORD = resourceBundle.getString("PASSWORD");
    String ROLE = resourceBundle.getString("ROLE");
%>

<html>
<head>
    <title><%=USERS%>
    </title>
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/show_list/table.css">
</head>
<body>

<ul class="login_signup">
    <c:choose>
        <c:when test="${user == null}">
            <li><a href="/signup.jsp"><%=SIGN_UP%>
            </a></li>
            <li><a href="/login.jsp"><%=LOG_IN%>
            </a></li>
        </c:when>
        <c:when test="${user != null}">
            <%=HELLO%> ${user.name}!
            <a href="/controller?command=logout"><%=LOGOUT%>
            </a>
        </c:when>
    </c:choose>
    <a href="/controller?command=changeLanguage"><c:out value="<%=CHANGE_LANGUAGE%>"/></a>
</ul>

<header>
    <h2 class="selection_comittee"><%=SELECTION_COMMITTEE%>
    </h2>
</header>

<nav>
    <ul class="Navigation">
        <li><a href="/"><%=HOME%>
        </a></li>
        <li><a href="#"><%=ABOUT%>
        </a></li>
        <li><a href="#"><%=SOME_FUNCTIONS%>
        </a>
            <c:if test="${user != null}">
                <ul>
                    <li><a href="/controller?command=showFaculties"><%=FACULTIES%>
                    </a></li>
                    <c:if test="${user.roleId == 2}">
                        <li><a href="/controller?command=showRoles"><%=ROLES%>
                        </a></li>
                        <li><a href="/controller?command=showStatements"><%=STATEMENTS%>
                        </a></li>
                        <li><a href="/controller?command=showSubjects"><%=SUBJECTS%>
                        </a></li>
                        <li><a href="/controller?command=showUsers"><%=USERS%>
                        </a></li>
                        <li><a href="/controller?command=showRegisteredUsers"><%=REG_USERS%>
                        </a></li>
                        <li><a href="/controller?command=calculateEntrants"><%=CALCULATE_AND_SHOW_ENTRANTS%>
                        </a></li>
                    </c:if>
                </ul>
            </c:if>
        </li>
        <li><a href="#"><%=SOMETHING_ELSE%>
        </a></li>
        <li><a href="#"><%=CONTACT%>
        </a></li>
    </ul>
</nav>


<table class="table">
    <caption><strong><%=USERS%>
    </strong></caption>
    <thead>
    <tr>
        <th><%=NAME%>
        </th>
        <th><%=LOGIN%>
        </th>
        <th><%=PASSWORD%>
        </th>
        <th><%=ROLE%>
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
</body>
</html>
